package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/roman-to-integer/
 */
class RomanToInteger {
    @Test
    void romanToIntTest() {
        assertEquals(3, romanToInt("III"));
        assertEquals(58, romanToInt("LVIII"));
        assertEquals(1994, romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        Map<Character, Integer> mapping = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if (i + 1 < s.length()) {
                char next = s.charAt(i + 1);
                // I before V (4), I before X (9)
                boolean substractForI = current == 'I' && (next == 'V' || next == 'X');
                // X before L (40), X before C (90)
                boolean substractForX = current == 'X' && (next == 'L' || next == 'C');
                // C before D (400), C before M (900)
                boolean substractForC = current == 'C' && (next == 'D' || next == 'M');

                if (substractForI || substractForX || substractForC) {
                    result -= mapping.get(current);
                    continue;
                }
            }

            result += mapping.get(current);
        }

        return result;
    }
}
