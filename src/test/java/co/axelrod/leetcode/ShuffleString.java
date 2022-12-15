package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/shuffle-string/
 */
class ShuffleString {
    @Test
    void restoreStringTest() {
        assertEquals("leetcode", restoreString("codeleet", new int[]{4, 5, 6, 7, 0, 2, 1, 3}));
        assertEquals("abc", restoreString("abc", new int[]{0, 1, 2}));
    }

    public String restoreString(String s, int[] indices) {
        char[] result = new char[indices.length];

        for (int i = 0; i < indices.length; i++) {
            result[indices[i]] = s.charAt(i);
        }

        return new String(result);
    }
}
