package com.module4.db;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.io.IOException;
import java.io.Reader;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static DBHandler handler;

    public static void addMember(String id, String name, String age, String city){
        if (!memberExists(id)) {
            String qu = "INSERT INTO MEMBER VALUES (" +
                    "'" + id + "'," +
                    "'" + name + "'," +
                    "'" + age + "'," +
                    "'" + city + "')";
            handler.execAction(qu);
        }
    }

    public static boolean memberExists(String id) {
        // Check if member with given ID already exists
        String query = "SELECT * FROM MEMBER WHERE ID = '" + id + "'";
        ResultSet resultSet = handler.execQuery(query);
        try {
            return resultSet.next(); // Returns true if member exists
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        // Init DBHandler
        handler = DBHandler.getHandler();

        String qu = "SELECT * FROM MEMBER";
        ResultSet resultSet = handler.execQuery(qu);

        // Testing remnant
        // addMember("1", "lexy", "23", "Toronto");

        // Self-explanatory
        writeCSVToDB("src/sample.csv");
        writeDBToCSV("C:\\Users\\proto\\IdeaProjects\\Module 4 Assignment\\src\\output\\");

        try {
            while (resultSet.next()) {
                String id = resultSet.getString("ID");
                String name = resultSet.getString("NAME");
                System.out.println("Entry> ID: " + id + "\tName: " + name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void writeCSVToDB(String csvFilePath) {
        try {
            Reader reader = new FileReader(csvFilePath);
            CSVParser parse = new CSVParser(reader, CSVFormat.DEFAULT);

            // Reads the csv and adds each member to the DB assuming the input csv is formatted as expected
            for (CSVRecord record : parse) {
                String id = record.get(0);
                String name = record.get(1);
                String age = record.get(2);
                String city = record.get(3);

                addMember(id, name, age, city);
            }

            parse.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeDBToCSV(String csvOutputFolder) {
        try {
            String qu = "SELECT * FROM MEMBER";
            ResultSet resultSet = handler.execQuery(qu);

            // Create the output folder if it doesn't exist
            File folder = new File(csvOutputFolder);
            if (!folder.exists()) {
                folder.mkdirs(); // Create output folder and directory if it does not yet exist
            }

            // Create the output file path
            String csvOutputPath = csvOutputFolder + File.separator + "output.csv";
            Writer write = new FileWriter(csvOutputPath);
            CSVPrinter print = new CSVPrinter(write, CSVFormat.DEFAULT);

            // Write column headers
            print.printRecord((Object[]) getColumnHeaders(resultSet));

            // Write data rows
            while (resultSet.next()) {
                String[] rowData = new String[resultSet.getMetaData().getColumnCount()];
                for (int i = 1; i <= rowData.length; i++) {
                    rowData[i - 1] = resultSet.getString(i);
                }
                print.printRecord((Object[]) rowData);
            }

            // Close resources
            print.close();
            write.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static String[] getColumnHeaders(ResultSet resultSet) throws SQLException {
        int columnCount = resultSet.getMetaData().getColumnCount();

        // Array to store Column headers
        String[] headers = new String[columnCount];

        // Check each column and retrieve their names
        for (int i = 1; i <= columnCount; i++) {
            headers[i - 1] = resultSet.getMetaData().getColumnName(i);
        }
        return headers;
    }
}
