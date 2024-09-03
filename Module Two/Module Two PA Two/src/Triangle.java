
public class Triangle extends GeometricObject {
    private double side1 = 1.0; // Default length for side1
    private double side2 = 1.0; // Default length for side2
    private double side3 = 1.0; // Default length for side3
    private double height;      // Height of the triangle

    // Default constructor that invokes the superclass default constructor
    public Triangle() {
        super();
    }

    // Constructor with specified sides, height, color, and fill status
    public Triangle(double side1, double side2, double side3, double height, String color, Boolean filled) {
        super(color, filled); // Calls superclass constructor to set color and fill status
        this.side1 = side1;  // Initializes side with provided value
        this.side2 = side2;
        this.side3 = side3;
        this.height = height; // Initializes height with the provided value
    }

    // Getter method for height
    public double getHeight() {
        return height;
    }

    // Getter method for side1
    public double getSide1() {
        return side1;
    }

    // Getter method for side2
    public double getSide2() {
        return side2;
    }

    // Getter method for side3
    public double getSide3() {
        return side3;
    }

    // Overrides getArea() method to calculate the area of the triangle
    @Override
    public double getArea() {
        return 0.5 * getSide1() * getHeight(); // Area formula: 1/2 * base * height
    }

    // Overrides getPerimeter() method to calculate the perimeter of the triangle
    @Override
    public double getPerimeter() {
        return getSide1() + getSide2() + getSide3(); // Sum of all three sides
    }

    // Returns a string representation of the triangle with all relevant properties
    @Override
    public String toString() {
        return "Triangle: side1 = " + getSide1() +
                ", side2 = " + getSide2() +
                ", side3 = " + getSide3() +
                ", height = " + getHeight() +
                ", area = " + getArea() +
                ", perimeter = " + getPerimeter() +
                ", color = " + getColor() +
                ", filled = " + isFilled();
    }
}

