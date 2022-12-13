package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 */
class ReverseVowelsOfAString {
    @Test
    void reverseVowelsTest() {
        assertEquals("", reverseVowels(""));
        assertEquals("A", reverseVowels("A"));
        assertEquals("B", reverseVowels("B"));
        assertEquals("holle", reverseVowels("hello"));
        assertEquals("leotcede", reverseVowels("leetcode"));
        assertEquals("Aa", reverseVowels("aA"));
        assertEquals(".,", reverseVowels(".,"));
        assertEquals("a a", reverseVowels("a a"));
    }

    public String reverseVowels(String s) {
        if (s.length() < 2) {
            return s;
        }

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        int begin = 0;
        int end = s.length() - 1;

        char[] result = new char[s.length()];

        while (begin <= end) {
            while (!vowels.contains(s.charAt(begin)) && begin < end) {
                result[begin] = s.charAt(begin);
                begin++;
            }
            while (!vowels.contains(s.charAt(end)) && end > begin) {
                result[end] = s.charAt(end);
                end--;
            }
            char temp = s.charAt(begin);
            result[begin] = s.charAt(end);
            result[end] = temp;
            begin++;
            end--;
        }

        return new String(result);
    }
}
