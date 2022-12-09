package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 */
class RemoveAllAdjacentDuplicatesInString {
    @Test
    void removeDuplicatesTest() {
        assertEquals("ca", removeDuplicates("abbaca"));
        assertEquals("ay", removeDuplicates("azxxzy"));
    }

    public String removeDuplicates(String s) {
        char[] stack = new char[s.length()];
        stack[0] = s.charAt(0);
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            char current = s.charAt(i);
            if (count > 0 && stack[count - 1] == current) {
                count--;
            } else {
                stack[count++] = current;
            }
        }

        return new String(stack, 0, count);
    }
}
