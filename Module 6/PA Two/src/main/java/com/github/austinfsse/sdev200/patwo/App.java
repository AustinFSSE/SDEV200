package com.github.austinfsse.sdev200.patwo;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class App extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Connect to DB");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/DatabaseGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();

    }
}
