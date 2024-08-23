import java.util.Scanner;


public class Main {

    public static void BMIinterpretation(double kilo){
        System.out.println("Enter your height in meters:");
        Scanner height = new Scanner(System.in);
        double number = height.nextDouble();
        double bmi = kilo / (number * number);
        System.out.printf("Your BMI is %.2f", bmi);
    }
    public static void poundsToKilos(double number) {
        double kilo = number * 0.45349237;
        BMIinterpretation(kilo);
    }

    public static void main(String[] args) {
        System.out.println("Enter your weight in pounds:");
        Scanner input = new Scanner(System.in);
        double weight = input.nextDouble();
        poundsToKilos(weight);

    }
}