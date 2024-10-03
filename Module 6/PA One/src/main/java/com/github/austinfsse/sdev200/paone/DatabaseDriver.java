package com.github.austinfsse.sdev200.paone;

import java.sql.*;

public class DatabaseDriver {

    private static final String DB_URL = "jdbc:sqlite:staffing.db";

    public static String getDbUrl() {
        return DB_URL;
    }

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

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

        try (Connection conn = connect();
             PreparedStatement preparedStatement = conn.prepareStatement(createTableSQL)) {
            preparedStatement.execute();
            System.out.println("Table created");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertRecord(String id, String firstName, String lastName, String mi, String address, String city, String state, String telephone) {


        String insertRecordSQL = "INSERT INTO Staff (ID_number, firstname, lastname, mi, address, city, state, telephone) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(insertRecordSQL)) {
            // Set parameters
            pstmt.setString(1, id);
            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName);
            pstmt.setString(4, mi);
            pstmt.setString(5, address);
            pstmt.setString(6, city);
            pstmt.setString(7, state);
            pstmt.setString(8, telephone);
            pstmt.executeUpdate();
            System.out.println("Record created");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public String[] viewRecord(String id) {
        String viewRecordSQL = "SELECT * FROM Staff WHERE ID_number = ?";
        String databaseURL = "jdbc:sqlite:staffing.db";
        String[] record = new String[8];

        try (Connection connn = DriverManager.getConnection(databaseURL);
             PreparedStatement stmt = connn.prepareStatement(viewRecordSQL)) {

            stmt.setString(1, id);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
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
            System.out.println(e.getMessage());
        }
        return record;
    }

    public void updateRecord(String url, String id, String firstName, String lastName, String mi, String address, String city, String state, String telephone) {
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(url)) {
            stmt.setString(1, id);
            stmt.setString(2, lastName);
            stmt.setString(3, firstName);
            stmt.setString(4, mi);
            stmt.setString(5, address);
            stmt.setString(6, state);
            stmt.setString(7, city);
            stmt.setString(8, telephone);
            stmt.executeUpdate();
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }
}


