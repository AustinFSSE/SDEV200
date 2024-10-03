package com.github.austinfsse.sdev200.paone;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    // The start method is the entry point for the JavaFX application
    @Override
    public void start(Stage stage) throws Exception {
        // Load the FXML file for the UI layout
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Database_Exercise.fxml"));
        Scene scene = new Scene(loader.load()); // Create a new Scene with the loaded layout
        stage.setScene(scene); // Set the scene for the stage (window)
        stage.resizableProperty().setValue(Boolean.FALSE); // Make the window non-resizable
        stage.setTitle("JavaFx FinalProject"); // Set the title of the window
        stage.show(); // Display the stage
    }

    // Main method to launch the application
    public static void main(String[] args) {
        launch(); // Call launch to start the JavaFX application
    }
}
