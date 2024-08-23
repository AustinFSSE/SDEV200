
import static java.lang.System.out;

public class ConversionDriver {
    public static void main(String[] args) {
        // Initializing an array of doubles representing lengths in feet
        double[] feet = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0};
        // Initializing an array of doubles representing lengths in meters
        double[] meter = {20.0, 25.0, 30.0, 35.0, 40.0, 45.0, 50.0, 55.0, 60.0, 65.0};

        // Printing the header of the table
        out.println("Feet   Meters   |   Meters   Feet   ");
        out.println("------------------------------------");

        // Initialize the index variable i to start the loop
        int i = 0;
        // Using a while loop to iterate over both arrays until the end is reached
        while (i < feet.length) {
            // Conditional to adjust formatting for indices less than 9
            if (i < 9) {
                // Printing formatted output:
                // - %.1f formats the foot and meter values to 1 decimal place
                // - %.3f formats the converted values to 3 decimal places
                out.printf("%.1f    %.3f    |   %.1f     %.3f",
                        feet[i], Conversions.footToMeter(feet[i]), meter[i], Conversions.meterToFoot(meter[i]));
                out.println(); // Print a newline for the next row
            }
            // For index 9 and above, a slight adjustment in formatting (fewer spaces for alignment)
            else {
                out.printf("%.1f   %.3f    |   %.1f     %.3f",
                        feet[i], Conversions.footToMeter(feet[i]), meter[i], Conversions.meterToFoot(meter[i]));
                out.println(); // Print a newline for the next row
            }
            // Increment the index variable to move to the next element in the array
            i++;
        }
    }
}
