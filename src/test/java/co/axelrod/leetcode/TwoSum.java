package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import static co.axelrod.leetcode.array.ArrayUtil.arrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/two-sum/
 */
class TwoSum {
    @Test
    void twoSumTest() {
        assertTrue(arrayEquals(new int[]{0, 1}, twoSum(new int[]{2, 7, 11, 15}, 9)));
        assertTrue(arrayEquals(new int[]{1, 2}, twoSum(new int[]{3, 2, 4}, 6)));
        assertTrue(arrayEquals(new int[]{0, 1}, twoSum(new int[]{3, 3}, 6)));
    }

    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                if(i != j && nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }
}
