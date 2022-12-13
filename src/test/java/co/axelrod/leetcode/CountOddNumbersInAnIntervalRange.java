package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/
 */
class CountOddNumbersInAnIntervalRange {
    @Test
    void countOddsTest() {
        assertEquals(3, countOdds(3, 7));
        assertEquals(1, countOdds(8, 10));
    }

    public int countOdds(int low, int high) {
        int result = (high - low) / 2;
        if (high % 2 == 1 || low % 2 == 1) {
            result++;
        }
        return result;
    }
}
