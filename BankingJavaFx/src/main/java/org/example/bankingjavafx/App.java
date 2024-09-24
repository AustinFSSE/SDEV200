package org.example.bankingjavafx;

import javafx.application.Application;

import javafx.stage.Stage;
import org.example.bankingjavafx.Models.Model;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {

        Model.getInstance().getViewFactory().showLoginWindow();

    }


}
