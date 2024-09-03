
/*
* Austin Martin
* 09/3/2024
* This program will check user input to ensure the entry is binary digits
* then the program will convert it to a decimal number
* */


import java.util.Scanner;

// Class to validate and convert binary strings to decimal numbers
public class Bin2Dec {

    // Validates if a string is a valid binary number
    public boolean isValid(String number) throws BinaryFormatException {
        return stringChecker(number);
    }

    // Checks each character to ensure it's either '0' or '1'
    private boolean stringChecker(String binary) throws BinaryFormatException {
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) != '0' && binary.charAt(i) != '1') {
                throw new BinaryFormatException("Not a valid binary number:\t" + binary);
            }
        }
        return true;
    }

    // Converts a valid binary string to its decimal equivalent
    public String conversion(String number) throws BinaryFormatException {
        int sum = 0;
        int multiplier = 0;
        if (isValid(number)) {
            for (int i = number.length() - 1; i >= 0; i--) {
                if (number.charAt(i) == '1') {
                    sum += (int) Math.pow(2, multiplier);
                }
                multiplier++;
            }
        }
        return String.valueOf(sum);
    }

    // Main method to test the validation and conversion of binary strings
    public static void main(String[] args) {
        Bin2Dec b = new Bin2Dec();
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a binary number: ");
        String binary = input.nextLine();
        try {
            System.out.println(b.isValid(binary) ? "Valid binary number" : "Invalid binary number");
            System.out.println(b.conversion(binary));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}