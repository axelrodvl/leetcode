package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 */
class MergeSortedArray {
    @Test
    void mergeTest() {
        int[] nums1;
        int[] nums2;

        nums1 = new int[]{1, 2, 3, 0, 0, 0};
        nums2 = new int[]{2, 5, 6};
        merge(nums1, 3, nums2, 3);
        assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, nums1);

        nums1 = new int[]{4, 0, 0, 0, 0, 0};
        nums2 = new int[]{1, 2, 3, 5, 6};
        merge(nums1, 1, nums2, 5);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, nums1);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;

        int top = m - 1;
        int bottom = n - 1;

        while (i != -1) {
            if (top > -1 && bottom > -1) {
                if (nums1[top] > nums2[bottom]) {
                    nums1[i] = nums1[top];
                    top--;
                } else {
                    nums1[i] = nums2[bottom];
                    bottom--;
                }
            } else {
                if (top > -1) {
                    nums1[i] = nums1[top];
                    top--;
                } else {
                    nums1[i] = nums2[bottom];
                    bottom--;
                }
            }
            i--;
        }
    }
}
