
public class RegularPolygon {

    private int n = 3;
    private double side = 1;
    private double x = 0; // x-coordinate
    private double y = 0; // y-coordinate

    RegularPolygon() {
        getPerimeter(getN(), getSide());
        getArea(getN(), getSide());
    }
    RegularPolygon(int n, double side, double x, double y) {
        setN(n);
        setSide(side);
        setX(x);
        setY(y);
        getPerimeter(n, side);
        getArea(n, side);
    }
    RegularPolygon(int n, double side) {
        setN(n);
        setSide(side);
        setN(0);
        setY(0);
        getPerimeter(n, side);
        getArea(n, side);
    }

    public int getN() {
        return n;
    }
    public void setN(int n) {
        this.n = n;
    }

    public double getSide() {
        return side;
    }
    public void setSide(double side) {
        this.side = side;
    }

    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }

    private double calculatePerimeter(int n, double side) {
        this.setN(n);
        this.setSide(side);
        return n * side;
    }
    private double calculateArea(int n, double side) {
        this.setN(n);
        this.setSide(side);
        return ((n * (side*side))/(4*Math.tan(Math.PI/n)));
    }

    public double getPerimeter(int n, double side) {
        return calculatePerimeter(n, side);
    }
    public double getArea(int n, double side) {
        return calculateArea(n, side);
    }



}
