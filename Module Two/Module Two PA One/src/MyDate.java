import java.util.Date;


public class MyDate {

    private int month;
    private int day;
    private int year;

    public MyDate(){
        setCurrentDate();
    }
    public MyDate(long elapsedTime) {
        setSpecifiedDate(elapsedTime);
    }
    public MyDate(int month, int day, int year) {
        setMonth(month);
        setDay(day);
        setYear(year);
    }

    private void setSpecifiedDate(long elapsedTime) {
        Date date = new Date(elapsedTime);
        this.year = date.getYear() + 1900;
        this.month = date.getMonth();
        this.day = date.getDate();
    }
    private void setCurrentDate() {
        Date currentDate = new Date();
        this.year = currentDate.getYear() + 1900;
        this.month = currentDate.getMonth() + 1;
        this.day = currentDate.getDate();
    }

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


    public String displayDate() {
        return getYear() + "-" + getMonth() + "-" + getDay();  // Returns the date as a formatted string
    }

    public static void main(String[] args) {

        // Using the no-arg constructor to create an object with the current date
        MyDate currentDate = new MyDate();
        System.out.println("Current Date: " + currentDate.displayDate());

        // Using the constructor with specified elapsed time
        MyDate specifiedDate = new MyDate(561555550000L);
        System.out.println("Specified Date: " + specifiedDate.displayDate());

        // Using the constructor with a manual entry
        MyDate date = new MyDate(8, 8, 1997);
        System.out.println("Specified Date: " + date.displayDate());
    }
}
