package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import static co.axelrod.leetcode.array.ArrayUtil.arrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/sort-colors/
 */
class SortColors {
    @Test
    void sortColorsTest() {
        int[] nums;

        nums = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(nums);
        assertTrue(arrayEquals(new int[]{0, 0, 1, 1, 2, 2}, nums));

        nums = new int[]{2, 0, 1};
        sortColors(nums);
        assertTrue(arrayEquals(new int[]{0, 1, 2}, nums));
    }

    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for(int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        for(int i = 0; i < nums.length; i++) {
            if (count[0] != 0) {
                count[0]--;
                nums[i] = 0;
            } else if (count[1] != 0) {
                count[1]--;
                nums[i] = 1;
            } else if (count[2] != 0) {
                nums[i] = 2;
            }
        }
    }
}
