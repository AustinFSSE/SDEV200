package org.example.secondassignment;


import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class AppController {

    @FXML
    private Circle circle;

    public void shapeClicked(MouseEvent mouseEvent) {
        circle.setFill(Color.BLACK);
    }

    public void shapeReleased(MouseEvent mouseEvent) {
        circle.setFill(Color.WHITE);
    }
}