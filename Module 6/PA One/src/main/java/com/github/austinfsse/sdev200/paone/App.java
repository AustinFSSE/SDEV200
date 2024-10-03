package com.github.austinfsse.sdev200.paone;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Database_Exercise.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setTitle("JavaFx FinalProject");
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
