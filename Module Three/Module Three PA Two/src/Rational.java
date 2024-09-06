import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Scanner;

public class Rational implements Comparable<Rational> {

    // Fields to hold the numerator and denominator of the rational number
    private final BigInteger numerator;
    private final BigInteger denominator;

    // Default constructor initializing numerator and denominator to zero
    public Rational() {
        numerator = BigInteger.ZERO;
        denominator = BigInteger.ZERO;
    }

    // Constructor that takes numerator and denominator as arguments
    // Simplifies the rational number by dividing both by their GCD
    public Rational(BigInteger numerator, BigInteger denominator) {
        if (denominator.equals(BigInteger.ZERO)) {
            throw new IllegalArgumentException("You cannot divide by zero!"); // Prevents division by zero
        }
        BigInteger gcd = numerator.gcd(denominator); // Finds the greatest common divisor
        this.numerator = numerator.divide(gcd); // Simplifies the numerator
        this.denominator = denominator.divide(gcd); // Simplifies the denominator
    }

    // Getter for numerator
    public BigInteger getNumerator() {
        return numerator;
    }

    // Getter for denominator
    public BigInteger getDenominator() {
        return denominator;
    }

    // Adds this rational number to another, returning a new Rational object
    public Rational add(Rational other) {
        // Cross-multiplies the numerators and adds them, then multiplies the denominators
        BigInteger numerator1 = this.numerator.multiply(other.getDenominator());
        BigInteger numerator2 = this.denominator.multiply(other.getNumerator());
        BigInteger multiplyDenom = this.denominator.multiply(other.getDenominator());
        return new Rational(numerator1.add(numerator2), multiplyDenom);
    }

    // Subtracts another rational number from this one, returning a new Rational object
    public Rational subtract(Rational other) {
        // Cross-multiplies the numerators and subtracts them, then multiplies the denominators
        BigInteger numerator1 = this.numerator.multiply(other.getDenominator());
        BigInteger numerator2 = this.denominator.multiply(other.getNumerator());
        BigInteger multiplyDenom = this.denominator.multiply(other.getDenominator());
        return new Rational(numerator1.subtract(numerator2), multiplyDenom);
    }

    // Multiplies this rational number by another, returning a new Rational object
    public Rational multiply(Rational other) {
        // Multiplies the numerators and the denominators
        BigInteger multiply1 = getNumerator().multiply(other.getNumerator());
        BigInteger multiply2 = getDenominator().multiply(other.getDenominator());
        return new Rational(multiply1, multiply2);
    }

    // Divides this rational number by another, returning a new Rational object
    public Rational div(Rational other) {
        // Multiplies by the reciprocal of the other rational number
        BigInteger divide1 = getNumerator().multiply(other.getDenominator());
        BigInteger divide2 = getDenominator().multiply(other.getNumerator());
        return new Rational(divide1, divide2);
    }

    // Converts the rational number to a string representation
    @Override
    public String toString() {
        // If the denominator is 1, just return the numerator as a string
        if (getDenominator().equals(BigInteger.ONE)) {
            return getNumerator().toString();
        }
        return getNumerator() + "/" + getDenominator(); // Otherwise, return in "numerator/denominator" format
    }

    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    @Override
    public boolean equals(Object other) {
        // Checks equality by comparing numerators, assuming denominator simplification
        return getNumerator().equals(((Rational) other).getNumerator());
    }

    // Compares this rational number to another for ordering
    @Override
    public int compareTo(Rational other) {
        // Compares the numerators of the rational numbers
        int result = getNumerator().compareTo(other.getNumerator());

        // Printing comparison details based on the result
        if (result == 0) {
            System.out.println(
                    getNumerator() + "/" + getDenominator() + " == " + other);
        }
        if (result < 0) {
            System.out.println(getNumerator() + "/" + getDenominator() + " < " + other.getNumerator() + "/" + other.getDenominator());
        }
        if (result > 0) {
            System.out.println(getNumerator() + "/" + getDenominator() + " > " + other.getNumerator() + "/" + other.getDenominator());
        }

        // Returns the comparison result of numerators
        return result;
    }

    // Divides two BigInteger numbers, returning a BigDecimal with specified precision
    public static BigDecimal divideIntegers(BigInteger numerator, BigInteger denominator) {
        // Converts the BigIntegers to BigDecimals for division
        BigDecimal decimal1 = new BigDecimal(numerator);
        BigDecimal decimal2 = new BigDecimal(denominator);

        // Checks for division by zero
        if (denominator.equals(BigInteger.ZERO)) {
            throw new IllegalArgumentException("You cannot divide by zero!");
        }

        // Performs division with a precision of 20 decimal places, rounding half-up
        return decimal1.divide(decimal2, 20, RoundingMode.HALF_UP);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Instruction for the user input format
        System.out.println("In order for this program to successfully run " +
                "you must provide a space between your numerator and " +
                "denominator for your rational number!");
        System.out.print("Enter the first Rational number: ");

        try {
            // Reads the first rational number
            BigInteger num = new BigInteger(sc.next());
            BigInteger den = new BigInteger(sc.next());
            System.out.println();

            // Reads the second rational number
            System.out.print("Enter the second Rational number: ");
            BigInteger num1 = new BigInteger(sc.next());
            BigInteger den1 = new BigInteger(sc.next());
            System.out.println();

            // Creates Rational objects for the inputs
            Rational r1 = new Rational(num, den);
            Rational r2 = new Rational(num1, den1);
            sc.close(); // Closes the scanner to free up resources

            // Performs arithmetic operations and displays the results
            System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
            System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
            System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
            System.out.println(r1 + " / " + r2 + " = " + r1.div(r2));
            System.out.printf("%s/%s is %s%n", num1, den1, divideIntegers(num1, den1));

        } catch (Exception e) {
            // Catches any exceptions and rethrows them as a runtime exception
            throw new RuntimeException(e);
        }
    }
}
