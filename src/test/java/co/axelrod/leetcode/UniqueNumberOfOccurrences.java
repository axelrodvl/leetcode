package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/unique-number-of-occurrences/
 */
public class UniqueNumberOfOccurrences {
    @Test
    void uniqueOccurrencesTest() {
        assertTrue(uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));
        assertTrue(uniqueOccurrences(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}));
        assertFalse(uniqueOccurrences(new int[]{1, 2}));
    }

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> intCount = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (intCount.containsKey(arr[i])) {
                intCount.put(arr[i], intCount.get(arr[i]) + 1);
            } else {
                intCount.put(arr[i], 1);
            }
        }

        Set<Integer> values = new HashSet<>(intCount.values());
        return intCount.size() == values.size();
    }
}
