/*
Austin Martin
8/23/2024
This program iterates throw two integer arrays and
confirms if they have the same elements regardless of order
 */


public class ArrayChecker {

    public static void main(String[] args) {
        // Initialize two 2D arrays to be compared
        int[][] m1 = {{51, 25, 6}, {22, 1, 4}, {24, 54, 6}};
        int[][] m2 = {{51, 22, 25}, {6, 4, 1}, {24, 54, 6}};

        // Print whether the two arrays contain the same numbers
        System.out.printf("These 2D arrays %s the same numbers",
                equals(m1, m2) ? "contain" : "do not contain");
    }

    // Checks if two 2D arrays contain the same numbers
    public static boolean equals(int[][] m1, int[][] m2) {
        // Check if the dimensions of the two matrices are the same
        if (m1.length != m2.length) {
            return false;
        }
        for (int i = 0; i < m1.length; i++) {
            if (m1[i].length != m2[i].length) {
                return false;
            }
        }

        // Check if both arrays have the same elements
        for (int[] row : m1) {
            for (int element : row) {
                // If an element in m1 is not found in m2, the arrays are not equal
                if (!elementExistsInSecondArray(element, m2)) {
                    return false;
                }
            }
        }
        return true;
    }

    // Checks if an element exists in the second 2D array
    private static boolean elementExistsInSecondArray(int element, int[][] m2) {
        // Iterate through each row and element in the second array
        for (int[] row : m2) {
            for (int anInt : row) {
                // Return true if the element is found
                if (anInt == element) {
                    return true;
                }
            }
        }
        // Return false if the element is not found
        return false;
    }
}
