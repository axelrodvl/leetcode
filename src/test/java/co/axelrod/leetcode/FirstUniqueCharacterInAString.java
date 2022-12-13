package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 */
class FirstUniqueCharacterInAString {
    @Test
    void firstUniqCharTest() {
        assertEquals(0, firstUniqChar("leetcode"));
        assertEquals(2, firstUniqChar("loveleetcode"));
        assertEquals(-1, firstUniqChar("aabb"));
    }

    public int firstUniqChar(String s) {
        int[] letter = new int[26];
        char a = 'a';

        for (int i = 0; i < s.length(); i++) {
            letter[s.charAt(i) - a]++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (letter[s.charAt(i) - a] == 1) {
                return i;
            }
        }

        return -1;
    }
}
