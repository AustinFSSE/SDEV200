import static java.lang.Character.*;

public class CreditCardValidator {

    // Checks if the given credit card number is valid
    public static boolean isValid(long number) {
        boolean check_one = false;
        boolean check_two = false;
        boolean check_three = false;

        // Check if the number length is between 13 and 16 digits
        if (getSize(number) > 12 && getSize(number) < 17) {
            check_one = true;
        }

        // Check if the number has a valid prefix
        if (prefixMatched(number, 4) || prefixMatched(number, 5) ||
                prefixMatched(number, 6) || prefixMatched(number, 37)) {
            check_two = true;
        }

        // Validate the number using the Luhn algorithm
        if ((sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0) {
            check_three = true;
        }

        return check_three && check_one && check_two;
    }

    // Calculates the sum of the digits that are doubled in the even places
    public static int sumOfDoubleEvenPlace(long number) {
        int sum = 0;
        String numberStr = Long.toString(number);
        for (int i = getSize(number) - 2; i >= 0; i -= 2) {
            sum += getDigit(getNumericValue(numberStr.charAt(i)) * 2);
        }
        return sum;
    }

    // Returns the sum of the digits of a number. If the number is greater than 9,
    // it returns the sum of its digits
    public static int getDigit(int number) {
        String numberStr = Long.toString(number);
        int sum = 0;
        if (number < 9) {
            return number;
        }
        for (int i = getSize(number) - 1; i >= 0; i--) {
            sum += getNumericValue(numberStr.charAt(i));
        }
        return sum;
    }

    // Calculates the sum of the digits in the odd places
    public static int sumOfOddPlace(long number) {
        int sum = 0;
        String numberStr = Long.toString(number);
        for (int i = getSize(number) - 1; i > 0; i -= 2) {
            sum += getDigit(getNumericValue(numberStr.charAt(i)));
        }
        return sum;
    }

    // Checks if the credit card number starts with a specified prefix
    public static boolean prefixMatched(long number, int d) {
        return getPrefix(number, getSize(d)) == d;
    }

    // Returns the number of digits in a number
    public static int getSize(long d) {
        return Long.toString(d).length();
    }

    // Returns the first k digits of a number. If the number has fewer digits than k,
    // it returns the number itself
    public static long getPrefix(long number, int k) {
        return Long.parseLong(Long.toString(number).substring(0, k));
    }
}
