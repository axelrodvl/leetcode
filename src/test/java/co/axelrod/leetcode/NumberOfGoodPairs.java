package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/number-of-good-pairs/
 */
class NumberOfGoodPairs {
    @Test
    void numIdenticalPairsTest() {
        assertEquals(4, numIdenticalPairsPerformanceOptimized(new int[]{1,2,3,1,1,3}));
        assertEquals(6, numIdenticalPairsPerformanceOptimized(new int[]{1,1,1,1}));
        assertEquals(0, numIdenticalPairsPerformanceOptimized(new int[]{1,2,3}));

        assertEquals(4, numIdenticalPairsMemoryOptimized(new int[]{1,2,3,1,1,3}));
        assertEquals(6, numIdenticalPairsMemoryOptimized(new int[]{1,1,1,1}));
        assertEquals(0, numIdenticalPairsMemoryOptimized(new int[]{1,2,3}));
    }

    public int numIdenticalPairsPerformanceOptimized(int[] nums) {
        int good = 0;
        Map<Integer, Integer> pairs = new HashMap<>();
        for (int num : nums) {
            if (pairs.containsKey(num)) {
                pairs.put(num, pairs.get(num) + 1);
            } else {
                pairs.put(num, 0);
            }
            good += pairs.get(num);
        }
        return good;
    }

    public int numIdenticalPairsMemoryOptimized(int[] nums) {
        int good = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] == nums[j] && i < j) {
                    good++;
                }
            }
        }
        return good;
    }
}
