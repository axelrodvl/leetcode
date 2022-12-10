package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/binary-search/
 */
class BinarySearch {
    @Test
    void searchTest() {
        assertEquals(4, search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        assertEquals(-1, search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
    }

    public int search(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;

        while (begin < end && end - begin > 1) {
            int middle = (begin + end) / 2;
            if (nums[middle] < target) {
                begin = middle;
            } else {
                end = middle;
            }
        }

        if (nums[begin] == target) {
            return begin;
        }
        if (nums[end] == target) {
            return end;
        }

        return -1;
    }
}
