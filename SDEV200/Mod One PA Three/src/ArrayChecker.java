

public class ArrayChecker {
    public static void main(String[] args) {

        int[][] m1 = {{51, 25, 6}, {22, 1, 4}, {24, 54, 6}};
        int[][] m2 = {{51, 22, 25}, {6, 4, 1}, {24, 54, 6}};
        System.out.printf("These 2D arrays %s the same numbers",
                equals(m1, m2) ? "contain" : "do not contain");
    }

    public static boolean equals (int[][] m1, int[][] m2) {
        if (m1.length != m2.length) {
            return false;
        }
        for (int i = 0; i < m1.length; i++) {
            if (m1[i].length != m2[i].length) {
                return false;
            }
        }
        for (int[] ints : m1) {
            for (int element : ints) {
                if (!elementExistsInSecondArray(element, m2)) {
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean elementExistsInSecondArray(int element, int[][] m2) {
        for (int[] ints : m2) {
            for (int anInt : ints) {
                if (anInt == element) {
                    return true;
                }
            }
        }
        return false;
    }
}
