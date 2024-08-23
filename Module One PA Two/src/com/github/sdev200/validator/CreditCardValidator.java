package com.github.sdev200.validator;


import static java.lang.Character.*;

public class CreditCardValidator {

    public static boolean isValid(long number) {
        boolean check_one = false;
        boolean check_two = false;
        boolean check_three = false;
        if (getSize(number) > 12 && getSize(number) < 17) {
            check_one = true;
        }
        if (prefixMatched(number, 4) || prefixMatched(number, 5) || prefixMatched(number, 6) || prefixMatched(number, 37)) {
            check_two = true;
        }
        if ((sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0){
            check_three = true;
        }
        return check_three && check_one && check_two;
    }
    public static int sumOfDoubleEvenPlace(long number) {
       int sum = 0;
       String numberStr = Long.toString(number);
       for (int i = getSize(number) - 2; i >= 0; i -= 2) {
            sum += getDigit(getNumericValue(numberStr.charAt(i)) * 2);
       }
       return sum;
    }
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
    public static int sumOfOddPlace(long number) {
        int sum = 0;
        String numberSTR = Long.toString(number);
        for (int i = getSize(number) - 1; i > 0; i -=2){
            sum += getDigit(getNumericValue(numberSTR.charAt(i)));
        }
        return sum;
    }
    public static boolean prefixMatched(long number, int d) {
        return getPrefix(number, getSize(d)) == d;
    }
    public static int getSize(long d) {
        return Long.toString(d).length();
    }
    public static long getPrefix(long number, int k) {
        return Long.parseLong(Long.toString(number).substring(0, k));
    }

}
