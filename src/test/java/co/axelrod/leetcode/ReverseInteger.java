package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseInteger {
    @Test
    void reverseTest() {
        assertEquals(321, reverse(123));
        assertEquals(-321, reverse(-123));
        assertEquals(21, reverse(120));
    }

    public int reverse(int x) {
        boolean negative = x < 0;
        if (negative) {
            x *= -1;
        }
        long result = 0;
        while(x > 0) {
            result = result * 10 + x % 10;
            if(result > Integer.MAX_VALUE) {
                return 0;
            }
            x /= 10;
        }
        return negative ? (int) result * - 1 : (int) result;
    }
}
