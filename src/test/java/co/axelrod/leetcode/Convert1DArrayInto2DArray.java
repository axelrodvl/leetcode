package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://leetcode.com/problems/convert-1d-array-into-2d-array/
 */
class Convert1DArrayInto2DArray {
    @Test
    void construct2DArrayTest() {
        assertArrayEquals(new int[][]{
                {1,2},
                {3,4}
        }, construct2DArray(new int[]{1,2,3,4}, 2, 2));

        assertArrayEquals(new int[][]{
                {1,2,3}
        }, construct2DArray(new int[]{1,2,3}, 1, 3));

        assertArrayEquals(new int[][]{}, construct2DArray(new int[]{1,2}, 1, 1));
    }

    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[][]{};
        }

        int[][] result = new int[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = original[count++];
            }
        }
        return result;
    }
}
