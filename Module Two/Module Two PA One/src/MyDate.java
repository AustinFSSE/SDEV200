/*
* Austin Martin
* 09/03/2024
* This program will retrieve the current day, month, year
* also if you put in a large number in milliseconds it will convert that into a specific day
* passed the year 1900
*
* */


import java.util.Date;

public class MyDate {

    private int month;
    private int day;
    private int year;

    // Constructor to initialize with the current date
    public MyDate(){
        setCurrentDate();
    }

    // Constructor to initialize date using elapsed time since January 1, 1970
    public MyDate(long elapsedTime) {
        setSpecifiedDate(elapsedTime);
    }

    // Constructor to initialize date with specific month, day, and year
    public MyDate(int month, int day, int year) {
        setMonth(month);
        setDay(day);
        setYear(year);
    }

    // Sets the date based on elapsed time
    private void setSpecifiedDate(long elapsedTime) {
        Date date = new Date(elapsedTime);
        this.year = date.getYear() + 1900; // Years are offset by 1900
        this.month = date.getMonth();      // Months are zero-indexed
        this.day = date.getDate();         // Retrieves the day of the month
    }

    // Sets the date to the current system date
    private void setCurrentDate() {
        Date currentDate = new Date();
        this.year = currentDate.getYear() + 1900;
        this.month = currentDate.getMonth() + 1; // Adjust month to be 1-indexed
        this.day = currentDate.getDate();
    }

    // Getter and setter methods for day, month, and year
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    // Returns the date as a formatted string
    public String displayDate() {
        return getYear() + "-" + getMonth() + "-" + getDay();
    }

    public static void main(String[] args) {

        // Create a MyDate object with the current date
        MyDate currentDate = new MyDate();
        System.out.println("Current Date: " + currentDate.displayDate());

        // Create a MyDate object using a specified elapsed time
        MyDate specifiedDate = new MyDate(561555550000L);
        System.out.println("Specified Date: " + specifiedDate.displayDate());

        // Create a MyDate object with a specified date
        MyDate date = new MyDate(8, 8, 1997);
        System.out.println("Specified Date: " + date.displayDate());
    }
}
