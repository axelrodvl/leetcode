package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/ransom-note/
 */
class RansomNote {
    @Test
    void canConstructTest() {
        assertFalse(canConstruct("a", "b"));
        assertFalse(canConstruct("aa", "ab"));
        assertTrue(canConstruct("aa", "aab"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letters = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            letters[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 'a';
            if (letters[index] == 0) {
                return false;
            }
            letters[index]--;
        }

        return true;
    }
}
