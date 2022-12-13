package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/valid-palindrome-ii/
 */
class ValidPalindromeII {
    @Test
    void validPalindromeTest() {
        assertTrue(validPalindrome("aba"));
        assertTrue(validPalindrome("abca"));
        assertTrue(validPalindrome("cdbeeeabddddbaeedebdc"));
        assertTrue(validPalindrome("ebcbbececabbacecbbcbe"));
        assertFalse(validPalindrome("abc"));
    }

    public boolean validPalindrome(String s) {
        int begin = 0;
        int end = s.length() - 1;
        boolean skipped = false;
        boolean option2 = false;

        int savedBegin = 0;
        int savedEnd = 0;

        while (begin <= end) {
            if (s.charAt(begin) == s.charAt(end)) {
                begin++;
                end--;
            } else {
                if (skipped) {
                    if (option2) {
                        return false;
                    } else {
                        begin = savedBegin;
                        end = savedEnd;

                        if (s.charAt(begin + 1) == s.charAt(end)) {
                            begin++;
                        } else if (s.charAt(begin) == s.charAt(end - 1)) {
                            end--;
                        }

                        option2 = true;
                    }
                } else {
                    savedBegin = begin;
                    savedEnd = end;
                    if (s.charAt(begin) == s.charAt(end - 1)) {
                        end--;
                    } else if (s.charAt(begin + 1) == s.charAt(end)) {
                        begin++;
                    }
                    skipped = true;
                }
            }
        }

        return true;
    }
}
