package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/find-the-difference-of-two-arrays/
 */
class FindTheDifferenceOfTwoArrays {
    @Test
    void findDifferenceTest() {
        assertTrue(Arrays.asList(1, 3).containsAll(findDifference(new int[]{1, 2, 3}, new int[]{2, 4, 6}).get(0)));
        assertTrue(Arrays.asList(4, 6).containsAll(findDifference(new int[]{1, 2, 3}, new int[]{2, 4, 6}).get(1)));

        assertTrue(Arrays.asList(-81,-35,-10,-28,-61,-45,-15,14,-80,63).containsAll(findDifference(new int[]{-80,-15,-81,-28,-61,63,14,-45,-35,-10}, new int[]{-1,-40,-44,41,10,-43,69,10,2}).get(0)));
        assertTrue(Arrays.asList(-1,2,69,-40,41,10,-43,-44).containsAll(findDifference(new int[]{-80,-15,-81,-28,-61,63,14,-45,-35,-10}, new int[]{-1,-40,-44,41,10,-43,69,10,2}).get(1)));
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Map<Integer, Integer> all = new HashMap<>();
        for (int num : nums1) {
            all.put(num, 1);
        }
        for (int num : nums2) {
            if (all.containsKey(num)) {
                if (all.get(num) == 1) {
                    all.put(num, 3);
                }
            } else {
                all.put(num, 2);
            }
        }

        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : all.entrySet()) {
            if (entry.getValue() == 1) {
                first.add(entry.getKey());
            }
            if (entry.getValue() == 2) {
                second.add(entry.getKey());
            }
        }

        return Arrays.asList(first, second);
    }
}
