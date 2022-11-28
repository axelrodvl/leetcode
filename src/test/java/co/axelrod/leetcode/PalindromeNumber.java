package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/palindrome-number/
 */
class PalindromeNumber {
    @Test
    void isPalindromeTest() {
        assertTrue(isPalindrome(1));
        assertTrue(isPalindrome(11));
        assertTrue(isPalindrome(121));
        assertTrue(isPalindrome(100010001));
        assertFalse(isPalindrome(-1));
        assertFalse(isPalindrome(122));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        if (x < 10) {
            return true;
        }

        int number = x;
        int revertedNumber = 0;
        while (number > 0) {
            revertedNumber = revertedNumber * 10 + number % 10;
            number /= 10;
        }

        return x == revertedNumber;
    }
}
