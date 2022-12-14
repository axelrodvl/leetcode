package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
 */
class CheckIfTwoStringArraysAreEquivalent {
    @Test
    void arrayStringsAreEqualTest() {
        assertTrue(arrayStringsAreEqual(
                new String[]{
                        "ab", "c"
                },
                new String[]{
                        "a", "bc"
                }
        ));

        assertFalse(arrayStringsAreEqual(
                new String[]{
                        "a", "cb"
                },
                new String[]{
                        "ab", "c"
                }
        ));

        assertTrue(arrayStringsAreEqual(
                new String[]{
                        "abc", "d", "defg"
                },
                new String[]{
                        "abcddefg"
                }
        ));

        assertFalse(arrayStringsAreEqual(
                new String[]{
                        "ab", "c"
                },
                new String[]{
                        "a","bcd"
                }
        ));

        assertFalse(arrayStringsAreEqual(
                new String[]{
                        "a",
                },
                new String[]{
                        "a","b"
                }
        ));
    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int word = 0;
        int symbol = 0;

        for (int i = 0; i < word1.length; i++) {
            for (int j = 0; j < word1[i].length(); j++) {
                if (symbol >= word2[word].length()) {
                    word++;
                    symbol = 0;

                    if (word > word2.length - 1) {
                        return false;
                    }
                }

                if (word1[i].charAt(j) != word2[word].charAt(symbol)) {
                    return false;
                }
                symbol++;
            }
        }

        if (symbol < word2[word].length() || word < word2.length - 1) {
            return false;
        }

        return true;
    }
}
