

// Custom Exception class that differs from NumberFormatException
public class BinaryFormatException extends Exception {
    public BinaryFormatException() {
        super("Invalid binary number!");
    }
    public BinaryFormatException(String message) {
        super(message);
    }

}
