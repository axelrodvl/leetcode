package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {
    @Test
    void test() {
        assertTrue(isValid("(())"));
        assertTrue(isValid("()[]{}"));
        assertFalse(isValid("(]"));
        assertFalse(isValid("((())))"));
        assertFalse(isValid(")))"));
        assertFalse(isValid("(])"));
    }

    boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int size = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack[size++] = c;
            } else {
                if (size == 0) {
                    return false;
                }
                char last = stack[size - 1];
                if (c == ')' && last == '(') {
                    size--;
                } else if (c == '}' && last == '{') {
                    size--;
                } else if (c == ']' && last == '[') {
                    size--;
                } else {
                    stack[size++] = c;
                }
            }
        }
        return size == 0;
    }
}
