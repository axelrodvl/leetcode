package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/find-the-difference/
 */
class FindTheDifference {
    @Test
    void findTheDifferenceTest() {
        assertEquals('e', findTheDifference("abcd", "abcde"));
        assertEquals('y', findTheDifference("", "y"));
    }

    public char findTheDifference(String s, String t) {
        char x = 0;
        for (char c : s.toCharArray()) {
            x ^= c;
        }
        for (char c : t.toCharArray()) {
            x ^= c;
        }
        return x;
    }
}
