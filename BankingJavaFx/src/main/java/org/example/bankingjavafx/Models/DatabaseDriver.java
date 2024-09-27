package org.example.bankingjavafx.Models;

import java.sql.*;

public class DatabaseDriver {

    private Connection conn;
    public DatabaseDriver() throws SQLException {
        try {
            this.conn = DriverManager.getConnection("jdbc:sqlite:bankingjavafx");
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public ResultSet getClientData(String pAddress, String password) {
        Statement statement;
        ResultSet resultSet;
        try {
            statement =  this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Clients WHERE PayeeAddress='"+pAddress+"' AND Password='"+password+"';");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }


    /*
    Client Section
     */

    /*
    Admin Section
     */

    /*
    Utility Methods
     */
}
