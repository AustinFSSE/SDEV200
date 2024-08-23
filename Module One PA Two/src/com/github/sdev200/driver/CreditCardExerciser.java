package com.github.sdev200.driver;

import java.util.*;

import static com.github.sdev200.validator.CreditCardValidator.*;
import static java.lang.System.out;


public class CreditCardExerciser {

    public static void main(String[] args) {
        out.println("Please enter your card number");
        Scanner input = new Scanner(System.in);
        long cardNumber = input.nextLong();

        if (isValid(cardNumber)){
            out.printf("%d is valid", cardNumber);
        }
        else {
            out.printf("%d is not valid", cardNumber);
        }
    }
}
