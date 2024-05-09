package com.module4.db;

import java.sql.*;

public class DBHandler {
    private static final String DB_url = "jdbc:derby:database/myDB;create=true";
    private static Connection conn = null;
    private static Statement stmt = null;
    public static DBHandler handler;

    public  DBHandler() {
        createConnection();
        createTable();
    }

    public static DBHandler getHandler() {
        if (handler == null) {
            handler = new DBHandler();
            return handler;
        } else {
            return handler;
        }
    }

    private void createTable() {
        String tbl = "MEMBER";
        try {
            stmt = conn.createStatement();
            DatabaseMetaData dmn = conn.getMetaData();
            ResultSet tables = dmn.getTables(null, null, tbl, null);
            if(tables.next()) {
                System.out.println("Table " + tbl + " exists");
            } else {
                String statement = "CREATE TABLE " + tbl + " ("
                        + "id varchar(200) primary key, \n"
                        + "name varchar(200), \n"
                        + "age varchar(200), \n"
                        + "city varchar(200))";
                System.out.println(statement);
                stmt.execute(statement);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void createConnection() {
        try {
            conn = DriverManager.getConnection(DB_url);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean execAction(String qu) {
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

    public ResultSet execQuery(String query) {
        ResultSet resultSet;
        try {
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return resultSet;
    }

}
