package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://leetcode.com/problems/reverse-string/
 */
class ReverseString {
    @Test
    void reverseStringTest() {
        char[] input;
        char[] output;

        input = new char[]{'h','e','l','l','o'};
        reverseString(input);
        output = new char[]{'o','l','l','e','h'};
        assertArrayEquals(output, input);

        input = new char[]{'H','a','n','n','a','h'};
        reverseString(input);
        output = new char[]{'h','a','n','n','a','H'};
        assertArrayEquals(output, input);
    }

    public void reverseString(char[] s) {
        char c;
        for(int i = 0; i < s.length / 2; i++) {
            c = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = c;
        }
    }
}
