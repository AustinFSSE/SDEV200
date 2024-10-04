package com.github.austinfsse.sdev200.patwo;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

// Controller for database connections and transitions
public class DatabaseController implements Initializable {

    DatabaseDriver driver = new DatabaseDriver();
    public Label database_lbl, error_lbl;
    public TextField jdbc_drive_fld, db_url_fld;
    public Button terminate_btn, connect_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        jdbc_drive_fld.setText("com.github.austinfsse.sdev200.patwo.DatabaseDriver");
        db_url_fld.setText("jdbc:sqlite:database.db");
        driver.setUrl("jdbc:sqlite:database.db");

        // Set up connection button action
        connect_btn.setOnAction(e -> {
            try {
                driver.setUrl(db_url_fld.getText());
                driver.createTables();
                database_lbl.setText("CONNECTED -> " + db_url_fld.getText());
                showBatchScreen();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                error_lbl.setText("Connection Failed");
            }
        });
    }

    // Load and display the Batch screen
    public void showBatchScreen() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Batch.fxml"));
        createStage(fxmlLoader);
    }

    // Helper method to create a new window
    private void createStage(FXMLLoader loader) {
        Scene scene;
        try {
            scene = new Scene(loader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("JavaFx FinalProject");
        stage.show();
    }

    // Close a stage
    private void closeStage(Stage stage) {
        stage.close();
    }
}
