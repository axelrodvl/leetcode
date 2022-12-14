package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
class RemoveDuplicatesFromSortedArray {
    @Test
    void removeDuplicatesTest() {
        int[] nums;
        int[] expectedNums;
        int k;

        // Test 1
        nums = new int[]{1, 1, 2}; // Input array
        expectedNums = new int[]{1, 2}; // The expected answer with correct length

        k = removeDuplicates(nums); // Calls your implementation

        assertEquals(k, expectedNums.length);
        for (int i = 0; i < k; i++) {
            assertEquals(nums[i], expectedNums[i]);
        }

        // Test 2
        nums = new int[]{0,0,1,1,1,2,2,3,3,4}; // Input array
        expectedNums = new int[]{0,1,2,3,4}; // The expected answer with correct length

        k = removeDuplicates(nums); // Calls your implementation

        assertEquals(k, expectedNums.length);
        for (int i = 0; i < k; i++) {
            assertEquals(nums[i], expectedNums[i]);
        }
    }

    public int removeDuplicates(int[] nums) {
        int length = 1;
        int current = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != current) {
                current = nums[i];
                nums[length++] = current;
            }
        }
        return length;
    }
}
