


public class ArrayChecker {
    public static void main(String[] args) {
        int[][] m1 = {{51, 22, 25}, {6, 4, 1}, {78, 94, 31}};
        int[][] m2 = {{25, 51, 22}, {78, 31, 94}, {4, 1, 6}};

        System.out.printf("Your 2D arrays' %s matching elements!",
                equals(m1, m2) ? "contain" : "do not contain");
    }

    public static boolean equals(int[][] m1, int[][] m2) {
        if (m1.length != m2.length) {
            return false;
        }
        for (int i = 0; i < m1.length; i++) {
            if (m1[i].length != m2[i].length) {
                return false;
            }
        }
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[i].length; j++) {
                int element = m1[i][j];
                if (!elementExistsInSecondArray(element, m2))
                    return false;
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
