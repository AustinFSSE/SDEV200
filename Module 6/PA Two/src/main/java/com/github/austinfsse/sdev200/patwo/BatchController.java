package com.github.austinfsse.sdev200.patwo;

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

    DatabaseDriver db = new DatabaseDriver();
    public Label batchTime_lbl;
    public Label no_batchTime_lbl;
    public Button batch_btn;
    public Button non_batch_btn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        batch_btn.setOnAction(e-> {
            batchQuery();
        });
        non_batch_btn.setOnAction(e-> {
            nonBatchQuery();
        });

    }

    private void batchQuery() {
        String insertSQL = "INSERT INTO batch VALUES(?, ?)";

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db")) {

            try (PreparedStatement ps = conn.prepareStatement(insertSQL)) {

                for (int i = 1; i <= 10000000; i++) {
                    ps.setInt(1, i);
                    ps.setInt(2, generateRandomNumbers());
                    ps.addBatch();
                }
                long start = System.currentTimeMillis();
                ps.executeBatch();
                System.out.println("Batch Inserted");
                long end = System.currentTimeMillis();
                long elapsed = end - start;
                batchTime_lbl.setText(elapsed + "ms");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void nonBatchQuery() {
        String insertSQL = "INSERT INTO nonbatch VALUES(?, ?)";

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db")) {

            try (PreparedStatement ps = conn.prepareStatement(insertSQL)) {
                long start = System.currentTimeMillis();
                for (int i = 1; i <= 10000000; i++) {
                    ps.setInt(1, i);
                    ps.setInt(2, generateRandomNumbers());
                    ps.execute();
                }
                long end = System.currentTimeMillis();
                long elapsed = end - start;
                no_batchTime_lbl.setText(elapsed + "ms");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    private int generateRandomNumbers() {
        Random rand = new Random();
        return rand.nextInt(1000);
    }
}
