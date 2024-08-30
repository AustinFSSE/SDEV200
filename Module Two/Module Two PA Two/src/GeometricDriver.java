import java.util.Scanner;


public class GeometricDriver {
    public static void main(String[] args) {
        boolean isFilled = false;
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a side of your triangle: ");
        double side = scan.nextDouble();
        System.out.println("Enter a side of your triangle: ");
        double side2 = scan.nextDouble();
        System.out.println("Enter a side of your triangle: ");
        double side3 = scan.nextDouble();
        System.out.println("Enter the height for your Triangle: ");
        double height = scan.nextDouble();
        System.out.println("Enter a color for your Triangle: ");
        String color = scan.next();
        System.out.println("Is the triangle filled with color? (yes/no)");
        String filled = scan.next();
        String lowerFilled = filled.toLowerCase();
        if (lowerFilled.equals("yes")) {
            isFilled = true;
        }
        Triangle triangle = new Triangle(side, side2, side3, height, color, isFilled);
        System.out.println(triangle);

    }
}
