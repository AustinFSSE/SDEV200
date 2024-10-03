package org.example.firstsqlitejavafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleJavaFXSQLiteApp extends Application {

    private static final String DB_URL = "jdbc:sqlite:mydatabase.db";

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX SQLite Example");

        Label label = new Label("Enter name:");
        TextField nameInput = new TextField();
        Button addButton = new Button("Add to Database");

        // Set button action
        addButton.setOnAction(e -> {
            String name = nameInput.getText();
            if (!name.isEmpty()) {
                insertRecord(name);
                nameInput.clear();
            }
        });

        VBox vbox = new VBox(10, label, nameInput, addButton);
        vbox.setPadding(new Insets(10));

        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Create table if not exists
        createTable();
    }

    // Create a connection to SQLite
    private Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    // Create a table in the SQLite database
    private void createTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS people ("
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " name TEXT NOT NULL"
                + ");";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
            System.out.println("Table created or already exists.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Insert a record into the SQLite database
    private void insertRecord(String name) {
        String insertSQL = "INSERT INTO people(name) VALUES('" + name + "');";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(insertSQL);
            System.out.println("Record inserted: " + name);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
