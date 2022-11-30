package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 */
class LongestCommonPrefix {
    @Test
    void longestCommonPrefixTest() {
        assertEquals("a", longestCommonPrefix(new String[]{"a"}));
        assertEquals("fl", longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        assertEquals("", longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder(strs[0]);

        for (String str : strs) {
            int minLength = Math.min(result.length(), str.length());
            int common = 0;
            while (common < minLength) {
                if (result.charAt(common) == str.charAt(common)) {
                    common++;
                } else {
                    break;
                }
            }
            result.delete(common, result.length());
        }

        return result.toString();
    }
}
