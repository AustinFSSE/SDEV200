package com.github.SDEV200.conversion;

public class Conversions {

    // Static method to convert feet to meters
    public static double footToMeter(double foot) {
        // Local variable to store the result of the conversion
        double meter;
        // Conversion logic: 1 foot = 0.305 meters
        meter = 0.305 * foot;

        // Returning the converted value in meters
        return meter;
    }

    // Static method to convert meters to feet
    public static double meterToFoot(double meter) {
        // Local variable to store the result of the conversion
        double foot;
        // Conversion logic: 1 meter = 3.279 feet
        foot = 3.279 * meter;

        // Returning the converted value in feet
        return foot;
    }
}
