package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/contains-duplicate/
 */
public class ContainsDuplicate {
    @Test
    void containsDuplicateTest() {
        assertTrue(containsDuplicate(new int[]{1, 2, 3, 1}));
        assertFalse(containsDuplicate(new int[]{1, 2, 3, 4}));
        assertTrue(containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        for (int number : nums) {
            if (unique.contains(number)) {
                return true;
            } else {
                unique.add(number);
            }
        }
        return false;
    }
}
