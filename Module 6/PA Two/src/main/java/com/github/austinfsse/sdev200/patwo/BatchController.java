package com.github.austinfsse.sdev200.patwo;

import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;

public class BatchController implements Initializable {

    DatabaseDriver db = new DatabaseDriver();  // Reference to database operations
    public Label batchTime_lbl;
    public Label no_batchTime_lbl;
    public Button batch_btn;
    public Button non_batch_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Set actions for buttons to call batch and non-batch queries
        batch_btn.setOnAction(e-> batchQuery());
        non_batch_btn.setOnAction(e-> nonBatchQuery());
    }

    // Executes batch insert into the database
    private void batchQuery() {
        String insertSQL = "INSERT INTO batch VALUES(?, ?)";

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db")) {
            conn.setAutoCommit(false);  // Disable auto-commit for batch processing

            try (PreparedStatement ps = conn.prepareStatement(insertSQL)) {
                for (int i = 1; i <= 10000000; i++) {
                    ps.setInt(1, i);
                    ps.setInt(2, generateRandomNumbers());
                    ps.addBatch();  // Add each query to the batch
                }

                long start = System.currentTimeMillis();  // Start timer
                ps.executeBatch();  // Execute batch
                conn.commit();  // Commit the transaction
                long end = System.currentTimeMillis();  // End timer

                long elapsed = end - start;
                Platform.runLater(() -> batchTime_lbl.setText(elapsed + "ms"));  // Update label on UI thread
            } catch (SQLException e) {
                conn.rollback();  // Rollback transaction on failure
                System.out.println(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Executes non-batch insert into the database
    private void nonBatchQuery() {
        String insertSQL = "INSERT INTO nonbatch VALUES(?, ?)";

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db")) {
            try (PreparedStatement ps = conn.prepareStatement(insertSQL)) {
                long start = System.currentTimeMillis();  // Start timer
                for (int i = 1; i <= 1000; i++) {
                    ps.setInt(1, i);
                    ps.setInt(2, generateRandomNumbers());
                    ps.execute();  // Execute query one at a time
                }
                long end = System.currentTimeMillis();  // End timer

                long elapsed = end - start;
                no_batchTime_lbl.setText(elapsed + "ms");  // Update label with elapsed time
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Generates random numbers for insertion
    private int generateRandomNumbers() {
        Random rand = new Random();
        return rand.nextInt(1000);  // Random number from 0 to 999
    }
}
