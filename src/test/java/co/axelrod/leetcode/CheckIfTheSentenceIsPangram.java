package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/check-if-the-sentence-is-pangram/
 */
class CheckIfTheSentenceIsPangram {
    @Test
    void checkIfPangramTest() {
        assertTrue(checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
        assertFalse(checkIfPangram("leetcode"));
    }

    public boolean checkIfPangram(String sentence) {
        boolean[] alphabet = new boolean[26];
        for (int i = 0; i < sentence.length(); i++) {
            int position = sentence.charAt(i) - 'a';
            alphabet[position] = true;
        }
        for (int i = 0; i < 26; i++) {
            if (!alphabet[i]) {
                return false;
            }
        }
        return true;
    }
}
