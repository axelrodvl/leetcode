package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/number-of-1-bits/
 */
class NumberOf1Bits {
    @Test
    void hammingWeightTest() {
        assertEquals(3, hammingWeight(11));  // 00000000000000000000000000001011
        assertEquals(1, hammingWeight(128)); // 00000000000000000000000010000000
        assertEquals(31, hammingWeight(-3)); // 11111111111111111111111111111101
    }

    // you need to treat n as an unsigned value
    public int hammingWeight(long n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += n & 1;
            n = n >> 1;
        }
        return count;
    }
}
