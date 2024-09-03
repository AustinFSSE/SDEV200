import java.util.Scanner;

public class GeometricDriver {
    public static void main(String[] args) {
        boolean isFilled = false; // Initialize fill status as false
        Scanner scan = new Scanner(System.in); // Create a Scanner object for user input

        // Prompt user to enter the sides and height of the triangle
        System.out.println("Enter a side of your triangle: ");
        double side = scan.nextDouble(); // Read first side length
        System.out.println("Enter a side of your triangle: ");
        double side2 = scan.nextDouble(); // Read second side length
        System.out.println("Enter a side of your triangle: ");
        double side3 = scan.nextDouble(); // Read third side length
        System.out.println("Enter the height for your Triangle: ");
        double height = scan.nextDouble(); // Read height of the triangle

        // Prompt user to enter the color of the triangle
        System.out.println("Enter a color for your Triangle: ");
        String color = scan.next(); // Read color input

        // Prompt user to specify if the triangle is filled with color
        System.out.println("Is the triangle filled with color? (yes/no)");
        String filled = scan.next();
        String lowerFilled = filled.toLowerCase(); // Convert input to lowercase for comparison

        // Determine fill status based on user input
        if (lowerFilled.equals("yes")) {
            isFilled = true;
        }

        // Create a Triangle object with the user's inputs
        Triangle triangle = new Triangle(side, side2, side3, height, color, isFilled);

        // Print the details of the triangle
        System.out.println(triangle);
    }
}

