package com.github.austinfsse.sdev200.patwo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseDriver {
    private String url;


    public Connection connect() {
        Connection conn = null; // Initialize the connection object
        try {
            conn = DriverManager.getConnection(getUrl()); // Attempt to connect to the database
        } catch (SQLException e) {
            System.out.println(e.getMessage()); // Print any SQL errors
        }
        return conn;
    }
    public void createTables() {
     String createBatchTable = "CREATE TABLE IF NOT EXISTS batch ("
         + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
         + "numbers VARCHAR(255) NOT NULL"
          + ");";
        String createNonBatchTable = "CREATE TABLE IF NOT EXISTS nonbatch ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "numbers VARCHAR(255) NOT NULL"
                + ");";

        try (Connection conn = connect();
             PreparedStatement preparedStatement = conn.prepareStatement(createBatchTable);
             PreparedStatement preparedStatement2 = conn.prepareStatement(createNonBatchTable)) {
            preparedStatement.execute(); // Execute the SQL statement to create the table'
            preparedStatement2.execute();
            System.out.println("Table created");
        } catch (SQLException e) {
            System.out.println(e.getMessage()); // Print any SQL errors
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
