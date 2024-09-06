
public class Circle extends GeometricObject implements Comparable<Circle> {
    private double radius = 0.0; // Field to store the radius of the circle

    // Default constructor initializing the circle with a radius of 0.0
    public Circle() {
        this(0.0);
    }

    // Constructor initializing the circle with the specified radius
    public Circle(double radius) {
        this.radius = radius;
    }

    // Overrides the equals method to compare Circle objects based on their radii
    @Override
    public boolean equals(Object obj) {
        // Checks if the passed object is an instance of Circle and performs type casting
        if (obj instanceof Circle c){
            // Compares the radii of the current circle and the passed circle
            return getRadius() == c.getRadius();
        }
        // Returns false if the object is not a Circle
        else {
            return false;
        }
    }

    // Calculates the area of the circle using the formula π * radius^2
    @Override
    public double getArea() {
        return Math.PI * getRadius() * getRadius();
    }

    // Calculates the perimeter of the circle using the formula 2 * π * radius
    @Override
    public double getPerimeter() {
        return Math.PI * getRadius() * 2;
    }

    // Getter method for the radius of the circle
    public double getRadius() {
        return radius;
    }

    // Implements the compareTo method to compare circles based on their radii
    @Override
    public int compareTo(Circle o) {
        if (getRadius() < o.getRadius()) {
            return -1; // Returns -1 if the current circle's radius is smaller
        }
        else if (getRadius() > o.getRadius()) {
            return 1; // Returns 1 if the current circle's radius is larger
        }
        return 0; // Returns 0 if both radii are equal
    }

    // Main method to test the Circle class functionality
    public static void main(String[] args) {
        Circle c1 = new Circle(1.0); // Creates a Circle object with radius 1.0
        Circle c2 = new Circle(1.0); // Creates another Circle object with radius 1.0

        // Checks if c1 is equal to c2 using the overridden equals method
        System.out.println(c1.equals(c2) ? "equal" : "not equal");
    }
}
