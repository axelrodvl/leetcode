package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/climbing-stairs/
 */
class ClimbingStairs {
    @Test
    void climbStairsTest() {
        assertEquals(1, climbStairs(1));
        assertEquals(2, climbStairs(2));
        assertEquals(3, climbStairs(3));
        assertEquals(5, climbStairs(4));
        assertEquals(8, climbStairs(5));
    }

    public int climbStairs(int n) {
        if (n == 1) {
            return n;
        }

        int prev = 1;
        int current = 2;
        while (--n > 1) {
            int next = prev + current;
            prev = current;
            current = next;
        }

        return current;
    }
}
