package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://leetcode.com/problems/shuffle-the-array/
 */
class ShuffleTheArray {
    @Test
    void shuffleTest() {
        assertArrayEquals(new int[]{2,3,5,4,1,7}, shuffle(new int[]{2,5,1,3,4,7}, 3));
        assertArrayEquals(new int[]{1,4,2,3,3,2,4,1}, shuffle(new int[]{1,2,3,4,4,3,2,1}, 4));
        assertArrayEquals(new int[]{1,2,1,2}, shuffle(new int[]{1,1,2,2}, 2));
    }

    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[n * 2];
        for (int i = 0; i < n; i++) {
            result[i * 2] = nums[i];
            result[i * 2 + 1] = nums[n + i];
        }
        return result;
    }
}
