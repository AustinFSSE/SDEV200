package org.example.thirdassignment;


import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ClockController extends Pane {

    private int hour;
    private int minute;
    private int second;

    public ClockController() {
        setCurrentTime();
    }

    public ClockController(int hour, int minute, int second) {
        setHour(hour);
        setMinute(minute);
        setSecond(second);
    }

    public int getHour() {
        return hour;
    }
    public void setHour(int hour) {
        this.hour = hour;
        paintClock();
    }

    public int getSecond() {
        return second;
    }
    public void setSecond(int second) {
        this.second = second;
        paintClock();
    }

    public int getMinute() {
        return minute;
    }
    public void setMinute(int minute) {
        this.minute = minute;
        paintClock();
    }

    public void setCurrentTime() {

        Calendar calendar = new GregorianCalendar();
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);

        paintClock();
    }

    private void paintClock() {

        double clockRadius = Math.min(getWidth(), getHeight()) * 0.8 * 0.5;
        double centerX = getWidth() / 2;
        double centerY = getHeight() / 2;

        Circle circle = new Circle(centerX, centerY, clockRadius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        Text top = new Text(centerX - 5, centerY - clockRadius + 12, "12");
        Text right = new Text(centerX + clockRadius - 10, centerY, "3");
        Text bottom = new Text(centerX - 3, centerY + clockRadius - 6, "6");
        Text left = new Text(centerX - clockRadius + 5, centerY, "9");

        double sLength = clockRadius * 0.8;
        double secondX = centerX + sLength * Math.sin(getSecond() * (2 * Math.PI / 60));
        double secondY = centerY - sLength * Math.cos(getSecond() * (2 * Math.PI / 60));

        Line sLine = new Line(centerX, centerY, secondX, secondY);
        sLine.setStroke(Color.RED);

        double mLength = clockRadius * 0.65;
        double xMinute = centerX + mLength * Math.sin(getMinute() * (2 * Math.PI / 60));
        double yMinute = centerY - mLength * Math.cos(getMinute() * (2 * Math.PI / 60));
        Line mLine = new Line(centerX, centerY, xMinute, yMinute);
        mLine.setStroke(Color.BLUE);


        double hLength = clockRadius * 0.5;
        double hourAngle = (getHour() % 12 + getMinute() / 60.0) * (2 * Math.PI / 12);
        double xHour = centerX + hLength * Math.sin(hourAngle);
        double yHour = centerY - hLength * Math.cos(hourAngle);
        Line hLine = new Line(centerX, centerY, xHour, yHour);
        hLine.setStroke(Color.GREEN);

        getChildren().clear();
        getChildren().addAll(circle, top, right, bottom, left, sLine, mLine, hLine);

    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        paintClock();
    }
    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        paintClock();
    }
}
















































