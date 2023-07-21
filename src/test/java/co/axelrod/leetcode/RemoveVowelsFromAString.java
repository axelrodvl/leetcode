package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/remove-vowels-from-a-string/
 */
class RemoveVowelsFromAString {
    @Test
    void removeVowelsTest() {
        assertEquals("ssssss", removeVowels("ssssss"));
        assertEquals("ltcdscmmntyfrcdrs", removeVowels("leetcodeisacommunityforcoders"));
        assertEquals("", removeVowels("aeiou"));
    }

    public String removeVowels(String s) {
        int length = s.length();
        char[] result = new char[length];
        int resultLength = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (pass(c)) {
                result[resultLength++] = c;
            }
        }
        return new String(result, 0, resultLength);
    }

    private boolean pass(char c) {
        return c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u';
    }
}
