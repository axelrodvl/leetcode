package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/search-insert-position/
 */
class SearchInsertPosition {
    @Test
    void searchInsertTest() {
        assertEquals(2, searchInsert(new int[]{1, 3, 5, 6}, 5));
        assertEquals(1, searchInsert(new int[]{1, 3, 5, 6}, 2));
        assertEquals(4, searchInsert(new int[]{1, 3, 5, 6}, 7));
        assertEquals(1, searchInsert(new int[]{1, 3}, 2));
    }

    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        if (nums[end] < target) {
            return nums.length;
        }

        if (target < nums[0]) {
            return 0;
        }

        int middle = (start + end) / 2;
        while (end - start > 1) {
            if (nums[middle] > target) {
                end = middle;
            } else {
                start = middle;
            }
            middle = (start + end) / 2;
        }

        if (nums[start] < target) {
            return middle + 1;
        }

        return middle;
    }
}
