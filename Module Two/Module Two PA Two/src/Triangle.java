
public class Triangle extends GeometricObject {
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;
    private double height;

   public Triangle() {
       super();
   }
    public Triangle(double side1, double side2, double side3, double height, String color, Boolean filled) {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.height = height;

    }
    public double getHeight() { return height; }
    public double getSide1() {
        return side1;
    }
    public double getSide2() {
        return side2;
    }
    public double getSide3() {
        return side3;
    }

    @Override
    public double getArea() {
        return 0.5*getSide1()*getHeight();
    }
    @Override
    public double getPerimeter() {
        return getSide1() + getSide2() + getSide3();
    }
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
