package org.example.thirdassignment;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.time.Clock;

public class ClockApp extends Application {
    @Override
    public void start(Stage stage) {

        AnchorPane pane = new AnchorPane();


        TextField hr = new TextField("00");
        hr.setPrefSize(50, 15);
        TextField min = new TextField("00");
        min.setPrefSize(50, 15);
        TextField sec = new TextField("00");
        sec.setPrefSize(50, 15);

        Label hrLabel = new Label("Hour: ");
        Label minLabel = new Label("Minutes: ");
        Label secLabel = new Label("Seconds: ");

        HBox hb = new HBox(10);
        hb.getChildren().addAll(hrLabel, hr, minLabel, min, secLabel, sec);
        ClockController clock = new ClockController(0,0,0);
        clock.setPrefSize(180, 180);
        Button submit = new Button("Submit");
        submit.setPrefSize(30, 20);

        submit.setOnAction(e -> {
            try {
                int hour = Integer.parseInt(hr.getText());
                int minutes = Integer.parseInt(min.getText());
                int seconds = Integer.parseInt(sec.getText());
                clock.setHour(hour);
                clock.setMinute(minutes);
                clock.setSecond(seconds);

            } catch (NumberFormatException ex) {
                System.out.println("Invalid hour/minute/second");
            }
        });


        AnchorPane.setBottomAnchor(submit, 10.0);
        AnchorPane.setLeftAnchor(submit, 150.0);
        AnchorPane.setRightAnchor(submit, 150.0);
        AnchorPane.setTopAnchor(clock, 10.0);
        AnchorPane.setLeftAnchor(clock, 100.0);
        AnchorPane.setBottomAnchor(hb, 50.0);
        AnchorPane.setLeftAnchor(hb, 20.0);
        AnchorPane.setRightAnchor(hb, 20.0);

        pane.getChildren().addAll(clock, hb, submit);

        Scene scene = new Scene(pane, 375, 300);
        stage.setScene(scene);
        stage.setTitle("Clock");
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
