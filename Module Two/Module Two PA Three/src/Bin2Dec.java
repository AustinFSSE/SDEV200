import java.util.Scanner;


// Programming Assignment 12.7 must be done first inorder to complete 12.9
public class Bin2Dec {

    public boolean isValid(String number) throws BinaryFormatException {
        return stringChecker(number);
    }
    private boolean stringChecker(String binary) throws BinaryFormatException {
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) != '0' && binary.charAt(i) != '1') {
                throw new BinaryFormatException("Not a valid binary number:\t" + binary);
            }
        }
        return true;
    }

    public String conversion(String number) throws BinaryFormatException {
        int sum = 0;
        int multiplier = 0;
        if (isValid(number)) {
            for (int i = number.length() - 1; i >= 0; i--) {
                if (number.charAt(i) == '1')
                {
                    sum += (int) Math.pow(2, multiplier);
                }
                multiplier++;
            }
        }
        return String.valueOf(sum);
    }
    public static void main(String[] args) {
        Bin2Dec b = new Bin2Dec();
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a binary number: ");
        String binary = input.nextLine();
        try {
            System.out.println(b.isValid(binary) ?
                    "Valid binary number" : "Invalid binary number");
            System.out.println(b.conversion(binary));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
