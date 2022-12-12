package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/
 */
class ReverseWordsInAStringIII {
    @Test
    void reverseWordsTest() {
        assertEquals("s'teL ekat edoCteeL tsetnoc", reverseWords("Let's take LeetCode contest"));
        assertEquals("doG gniD", reverseWords("God Ding"));
        assertEquals("I evol u", reverseWords("I love u"));
    }

    public String reverseWords(String s) {
        char[] reverse = new char[s.length()];

        int begin = 0;
        int end = 0;
        while (end <= s.length() - 1) {
            while (end < s.length() && s.charAt(end) != ' ') {
                end++;
            }

            for (int i = begin; i < end; i++) {
                reverse[i] = s.charAt(end - 1 + begin - i);
            }
            if (end < s.length()) {
                reverse[end] = ' ';
            }

            begin = end + 1;
            end = begin;
        }

        return new String(reverse);
    }
}
