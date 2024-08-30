import java.util.*;
import static java.lang.System.*;

public class CreditCardExerciser {

    public static void main(String[] args) {
        // Prompt user to enter their credit card number
        out.println("Please enter your card number");

        // Create a Scanner object to read input from the console
        Scanner input = new Scanner(System.in);

        // Read the credit card number entered by the user
        long cardNumber = input.nextLong();

        // Validate the credit card number using CreditCardValidator class
        if (CreditCardValidator.isValid(cardNumber)) {
            // If valid, print that the card number is valid
            out.printf("%d is valid", cardNumber);
        } else {
            // If not valid, print that the card number is not valid
            out.printf("%d is not valid", cardNumber);
        }

        // Close the scanner to free up resources
        input.close();
    }
}
