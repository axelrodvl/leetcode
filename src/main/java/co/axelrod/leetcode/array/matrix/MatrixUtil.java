package co.axelrod.leetcode.array.matrix;

public class MatrixUtil {
    private MatrixUtil() {
        // Utility class
    }

    public static boolean matrixIsEqual(int[][] a, int[][] b) {
        if (a.length != b.length) {
            return false;
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i].length != b[i].length) {
                return false;
            }
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
