package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://leetcode.com/problems/concatenation-of-array/
 */
class ConcatenationOfArray {
    @Test
    void getConcatenationTest() {
        assertArrayEquals(new int[]{1,2,1,1,2,1}, getConcatenation(new int[]{1,2,1}));
        assertArrayEquals(new int[]{1,3,2,1,1,3,2,1}, getConcatenation(new int[]{1,3,2,1}));
    }

    public int[] getConcatenation(int[] nums) {
        int[] result = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i];
            result[i + nums.length] = nums[i];
        }
        return result;
    }
}
