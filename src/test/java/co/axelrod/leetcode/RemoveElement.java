package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/remove-element/
 */
class RemoveElement {
    @Test
    void removeElementFirstTest() {
        int[] nums = new int[]{3, 2, 2, 3}; // Input array
        int val = 3; // Value to remove
        int[] expectedNums = new int[]{2, 2}; // The expected answer with correct length.
        // It is sorted with no values equaling val.

        int k = removeElement(nums, val); // Calls your implementation

        assertEquals(k, expectedNums.length);
        Arrays.sort(nums, 0, k); // Sort the first k elements of nums
        for (int i = 0; i < k; i++) {
            assertEquals(nums[i], expectedNums[i]);
        }
    }

    @Test
    void removeElementSecondTest() {
        int[] nums = new int[]{0, 4, 4, 0, 4, 4, 4, 0, 2}; // Input array
        int val = 4; // Value to remove
        int[] expectedNums = new int[]{0, 0, 0, 2}; // The expected answer with correct length.
        // It is sorted with no values equaling val.

        int k = removeElement(nums, val); // Calls your implementation

        assertEquals(k, expectedNums.length);
        Arrays.sort(nums, 0, k); // Sort the first k elements of nums
        for (int i = 0; i < k; i++) {
            assertEquals(nums[i], expectedNums[i]);
        }
    }

    @Test
    void removeElementThirdTest() {
        int[] nums = new int[]{3, 3}; // Input array
        int val = 3; // Value to remove
        int[] expectedNums = new int[]{}; // The expected answer with correct length.
        // It is sorted with no values equaling val.

        int k = removeElement(nums, val); // Calls your implementation

        assertEquals(k, expectedNums.length);
        Arrays.sort(nums, 0, k); // Sort the first k elements of nums
        for (int i = 0; i < k; i++) {
            assertEquals(nums[i], expectedNums[i]);
        }
    }

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1 && nums[0] == val) {
            return 0;
        }

        int top = nums.length - 1;
        int i = 0;
        while (i <= top) {
            if (nums[top] == val) {
                top--;
                if (top == -1) {
                    return 0;
                }
                continue;
            }

            if (nums[i] == val) {
                nums[i] = nums[top];
                top--;
            }

            i++;
        }

        return top + 1;
    }
}
