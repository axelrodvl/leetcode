package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/valid-palindrome/
 */
class ValidPalindrome {
    @Test
    void isPalindromeTest() {
        assertTrue(isPalindrome("A man, a plan, a canal: Panama"));
        assertTrue(isPalindrome(" "));
        assertFalse(isPalindrome("race a car"));
        assertTrue(isPalindrome(".,"));
        assertTrue(isPalindrome(".,,."));
        assertTrue(isPalindrome(".,aa,."));
    }

    public boolean isPalindrome(String s) {
        if (s.length() < 2) {
            return true;
        }

        Set<Character> alphanumeric = new HashSet<>();
        for (char i = 'a'; i <= 'z'; i++) {
            alphanumeric.add(i);
        }
        for (char i = 'A'; i <= 'Z'; i++) {
            alphanumeric.add(i);
        }
        for (char i = '0'; i <= '9'; i++) {
            alphanumeric.add(i);
        }

        int begin = 0;
        int end = s.length() - 1;

        while (begin <= end) {
            while (!alphanumeric.contains(s.charAt(begin)) && begin < end) {
                begin++;
            }
            while (!alphanumeric.contains(s.charAt(end)) && begin < end) {
                end--;
            }

            if (!alphanumeric.contains(s.charAt(begin)) && !alphanumeric.contains(s.charAt(end)) && begin >= end) {
                return true;
            }

            char atBegin = s.charAt(begin);
            int first = atBegin > 'Z' ? atBegin - 'a' : atBegin - 'A';
            char atEnd = s.charAt(end);
            int second = atEnd > 'Z' ? atEnd - 'a' : atEnd - 'A';
            if (first != second) {
                return false;
            }
            begin++;
            end--;
        }

        return true;
    }
}
