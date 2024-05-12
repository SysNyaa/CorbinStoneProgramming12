package com.module5.db;

import java.io.File;
import java.sql.*;

public class DBHandler {

    private static final String DB_path = "database/users";
    private static final String DB_url = "jdbc:derby:" + DB_path + ";create=true";
    private static Connection conn;
    private static Statement stmt;

    // Init DB
    public static void initialize() {
        // Check if the database file exists
        File dbFile = new File(DB_path);
        if (!dbFile.exists()) {
            System.out.println("Database does not exist.\nCreating database...");
            createDatabase();
        } else {
            System.out.println("Database exists");
        }
    }

    // As the name says
    private static void createDatabase() {
        // Default login
        String defaultUser = "admin";
        String defaultPass = "password";

        try {
            conn = DriverManager.getConnection(DB_url);
            if (conn != null) {
                stmt = conn.createStatement();
                // Create the users table
                System.out.println("Creating users table...");
                stmt.executeUpdate("CREATE TABLE users (id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, username VARCHAR(25), password VARCHAR(25))");
                // Create default user
                System.out.println("Adding default user...");
                addUser(defaultUser, defaultPass);

                System.out.println("Database created successfully.\n\nDefault account\nUser: \"" + defaultUser + "\" Password: \"" + defaultPass + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Checks if a username exists in the DB
    public static boolean userExists(String username) {
        String query = "SELECT * FROM users WHERE username = '" + username + "'";
        ResultSet resultSet = execQuery(query);
        try {
            return resultSet.next(); // If resultSet.next() is true, it means the user exists
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false in case of any exception
        }
    }

    public static void createConnection() {
        try {
            conn = DriverManager.getConnection(DB_url);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static boolean execAction(String qu) {
        try {
            stmt = conn.createStatement();
            stmt.execute(qu);
            return true;
        } catch (SQLException throwables) {
            System.out.println(throwables);
            System.out.println("No data");
        }
        return false;
    }

    public static ResultSet execQuery(String query) {
        ResultSet resultSet;
        try {
            if (conn == null) {
                createConnection();
            }
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return resultSet;
    }

    // Eerily similar to userExists could probably find a way to combine them, but I am NOT going that far this is easier
    public static boolean authenticateUser(String username, String password) {
        String query = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
        ResultSet resultSet = execQuery(query);
        try {
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Adds a user to the DB
    public static void addUser(String username, String password) {
        String query = "INSERT INTO users (username, password) VALUES ('" + username + "', '" + password + "')";
        execAction(query);
    }

    // Removes a user from the DB
    public static void rmUser(String username) {
        String query = "DELETE FROM users WHERE username = '" + username + "'";
        execAction(query);
    }

    // Changes a users password in the DB
    public static void changeUserPass(String username, String newPassword) {
        String query = "UPDATE users SET password = '" + newPassword + "' WHERE username = '" + username + "'";
        execAction(query);
    }

    // Retrieves all users from db and returns ResultSet containing them
    public static ResultSet getAllUsers() {
        String query = "SELECT * FROM users";
        return execQuery(query);
    }
}
