package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/isomorphic-strings/
 */
class IsomorphicStrings {
    @Test
    void isIsomorphicTest() {
        assertTrue(isIsomorphic("egg", "add"));
        assertTrue(isIsomorphic("paper", "title"));
        assertFalse(isIsomorphic("foo", "bar"));
        assertFalse(isIsomorphic("badc", "baba"));
        assertFalse(isIsomorphic("ab", "aa"));
    }

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> match = new HashMap<>();
        Set<Character> matchValues = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (!match.containsKey(s.charAt(i))) {
                match.put(s.charAt(i), t.charAt(i));
                if (matchValues.contains(t.charAt(i))) {
                    return false;
                } else {
                    matchValues.add(t.charAt(i));
                }
            } else {
                if (!(match.get(s.charAt(i)) == t.charAt(i))) {
                    return false;
                }
            }
        }

        return true;
    }
}
