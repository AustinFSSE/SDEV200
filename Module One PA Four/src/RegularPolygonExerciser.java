/*
Austin Martin
8/23/2024
This program creates different polygons and calculates the perimeter and area based on side length and number of sides
 */

public class RegularPolygonExerciser {

    public static void main(String[] args) {

        // Create instances of RegularPolygon
        RegularPolygon rp = new RegularPolygon();
        RegularPolygon rp1 = new RegularPolygon(4, 2);
        RegularPolygon rp2 = new RegularPolygon(3, 2, 2, 2);

        // Print the perimeter and area of each polygon
        System.out.printf("First Polygon Perimeter: %.1f\nFirst Polygon Area: %.2f\n",
                rp.getPerimeter(rp.getN(), rp.getSide()), rp.getArea(rp.getN(), rp.getSide()));

        System.out.printf("Second Polygon Perimeter: %.1f\nSecond Polygon Area: %.2f\n",
                rp1.getPerimeter(rp1.getN(), rp1.getSide()), rp1.getArea(rp1.getN(), rp1.getSide()));

        System.out.printf("Third Polygon Perimeter: %.1f\nThird Polygon Area: %.2f\n",
                rp2.getPerimeter(rp2.getN(), rp2.getSide()), rp2.getArea(rp2.getN(), rp2.getSide()));
    }
}
