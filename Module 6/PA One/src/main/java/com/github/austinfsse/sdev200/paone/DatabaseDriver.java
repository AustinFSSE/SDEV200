package com.github.austinfsse.sdev200.paone;

import java.sql.*; // Import JDBC classes for database connectivity

public class DatabaseDriver {

    // Database URL for SQLite
    private static final String DB_URL = "jdbc:sqlite:staffing.db";

    // Method to establish a connection to the database
    public Connection connect() {
        Connection conn = null; // Initialize the connection object
        try {
            conn = DriverManager.getConnection(DB_URL); // Attempt to connect to the database
        } catch (SQLException e) {
            System.out.println(e.getMessage()); // Print any SQL errors
        }
        return conn; // Return the connection object
    }

    // Method to create a staff table if it does not exist
    public void createTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS staff ("
                + "ID_number INTEGER PRIMARY KEY NOT NULL, "
                + "lastname varchar(15), "
                + "firstname varchar(15), "
                + "mi char(1),"
                + "address varchar(15),"
                + "city varchar(20),"
                + "state varchar(2),"
                + "Telephone char(10)"
                + ");";

        // Use try-with-resources to automatically close resources
        try (Connection conn = connect();
             PreparedStatement preparedStatement = conn.prepareStatement(createTableSQL)) {
            preparedStatement.execute(); // Execute the SQL statement to create the table
            System.out.println("Table created");
        } catch (SQLException e) {
            System.out.println(e.getMessage()); // Print any SQL errors
        }
    }

    // Method to insert a new record into the staff table
    public void insertRecord(String id, String firstName, String lastName, String mi, String address, String city, String state, String telephone) {
        String insertRecordSQL = "INSERT INTO Staff (ID_number, firstname, lastname, mi, address, city, state, telephone) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(insertRecordSQL)) {
            // Set parameters for the prepared statement
            pstmt.setString(1, id);
            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName);
            pstmt.setString(4, mi);
            pstmt.setString(5, address);
            pstmt.setString(6, city);
            pstmt.setString(7, state);
            pstmt.setString(8, telephone);
            pstmt.executeUpdate(); // Execute the insertion
            System.out.println("Record created");
        } catch (SQLException e) {
            System.out.println(e.getMessage()); // Print any SQL errors
        }
    }

    // Method to view a record by ID
    public String[] viewRecord(String id) {
        String viewRecordSQL = "SELECT * FROM Staff WHERE ID_number = ?"; // SQL query to fetch record
        String databaseURL = "jdbc:sqlite:staffing.db"; // Redundant declaration, can be removed
        String[] record = new String[8]; // Array to store record data

        try (Connection connn = DriverManager.getConnection(databaseURL);
             PreparedStatement stmt = connn.prepareStatement(viewRecordSQL)) {

            stmt.setString(1, id); // Set the ID parameter

            ResultSet rs = stmt.executeQuery(); // Execute the query
            while (rs.next()) {
                // Populate the record array with data from the ResultSet
                record[0] = rs.getString("ID_number");
                record[1] = rs.getString("firstname");
                record[2] = rs.getString("lastname");
                record[3] = rs.getString("mi");
                record[4] = rs.getString("address");
                record[5] = rs.getString("city");
                record[6] = rs.getString("state");
                record[7] = rs.getString("telephone");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage()); // Print any SQL errors
        }
        return record; // Return the record data
    }

    // Method to update a record
    public void updateRecord(String url, String id, String firstName, String lastName, String mi, String address, String city, String state, String telephone) {
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(url)) {
            // Set parameters for the prepared statement
            stmt.setString(1, id);
            stmt.setString(2, lastName);
            stmt.setString(3, firstName);
            stmt.setString(4, mi);
            stmt.setString(5, address);
            stmt.setString(6, state);
            stmt.setString(7, city);
            stmt.setString(8, telephone);
            stmt.executeUpdate(); // Execute the update
        } catch (SQLException exception) {
            System.out.println(exception.getMessage()); // Print any SQL errors
        }
    }
}
