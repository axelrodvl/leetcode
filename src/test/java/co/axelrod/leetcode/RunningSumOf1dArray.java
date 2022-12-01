package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import static co.axelrod.leetcode.array.ArrayUtil.arrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/running-sum-of-1d-array/
 */
public class RunningSumOf1dArray {
    @Test
    void runningSumTest() {
        assertTrue(arrayEquals(new int[]{1, 3, 6, 10}, runningSum(new int[]{1, 2, 3, 4})));
        assertTrue(arrayEquals(new int[]{1, 2, 3, 4, 5}, runningSum(new int[]{1, 1, 1, 1, 1})));
        assertTrue(arrayEquals(new int[]{3, 4, 6, 16, 17}, runningSum(new int[]{3, 1, 2, 10, 1})));
    }

    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
