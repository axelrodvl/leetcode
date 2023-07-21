package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/jewels-and-stones/
 */
class JewelsAndStones {
    @Test
    void numJewelsInStonesTest() {
        assertEquals(3, numJewelsInStones("aA", "aAAbbbb"));
        assertEquals(0, numJewelsInStones("z", "ZZ"));
    }

    public int numJewelsInStones(String jewels, String stones) {
        int result = 0;

        int[] stone = new int[52];
        for (int i = 0; i < stones.length(); i++) {
            char c = stones.charAt(i);
            stone[index(c)]++;
        }

        for (int i = 0; i < jewels.length(); i++) {
            result += stone[index(jewels.charAt(i))];
        }

        return result;
    }

    private int index(char c) {
        if (c >= 'a') {
            return c - 'a' + 26;
        } else {
            return c - 'A';
        }
    }
}
