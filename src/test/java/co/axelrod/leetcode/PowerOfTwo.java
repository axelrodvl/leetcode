package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/power-of-two/
 */
class PowerOfTwo {
    @Test
    void isPowerOfTwoTest() {
        assertTrue(isPowerOfTwo(1));
        assertTrue(isPowerOfTwo(16));
        assertFalse(isPowerOfTwo(3));
        assertFalse(isPowerOfTwo(-2147483648));
    }

    public boolean isPowerOfTwo(int n) {
        long x = n;
        return x != 0 && (x & -x) == x;
    }
}
