package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/fibonacci-number/
 */
class FibonacciNumber {
    @Test
    void fibTest() {
        assertEquals(0, fib(0));
        assertEquals(1, fib(1));
        assertEquals(1, fib(2));
        assertEquals(2, fib(3));
        assertEquals(3, fib(4));
        assertEquals(5, fib(5));
        assertEquals(8, fib(6));
    }

    public int fib(int n) {
        if (n < 2) {
            return n;
        }

        int first = 0;
        int second = 1;
        int result = 0;
        for (int i = 1; i < n; i++) {
            result = first + second;
            first = second;
            second = result;
        }

        return result;
    }
}
