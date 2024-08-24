import java.util.*;

import static java.lang.System.*;


public class CreditCardExerciser {

    public static void main(String[] args) {
        out.println("Please enter your card number");
        Scanner input = new Scanner(System.in);
        long cardNumber = input.nextLong();

        if (CreditCardValidator.isValid(cardNumber)){
            out.printf("%d is valid", cardNumber);
        }
        else {
            out.printf("%d is not valid", cardNumber);
        }
    }
}
