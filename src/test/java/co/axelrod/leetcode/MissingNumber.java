package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/missing-number/
 */
class MissingNumber {
    @Test
    void missingNumberTest() {
        assertEquals(2, missingNumber(new int[]{3, 0, 1}));
        assertEquals(2, missingNumber(new int[]{0, 1}));
        assertEquals(8, missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }

    public int missingNumber(int[] nums) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        return nums.length * (nums.length + 1) / 2 - sum;
    }
}
