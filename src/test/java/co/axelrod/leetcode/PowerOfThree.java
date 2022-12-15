package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/power-of-three/
 */
class PowerOfThree {
    @Test
    void isPowerOfThreeTest() {
        assertTrue(isPowerOfThree(1));
        assertTrue(isPowerOfThree(3));
        assertTrue(isPowerOfThree(9));
        assertTrue(isPowerOfThree(27));

        assertFalse(isPowerOfThree(-1));
        assertFalse(isPowerOfThree(0));
    }

    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        return 1162261467 % n == 0;
    }
}
