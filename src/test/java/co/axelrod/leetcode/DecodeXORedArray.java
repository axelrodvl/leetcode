package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://leetcode.com/problems/decode-xored-array/
 */
class DecodeXORedArray {
    @Test
    void decodeTest() {
        assertArrayEquals(new int[]{1,0,2,1}, decode(new int[]{1,2,3}, 1));
        assertArrayEquals(new int[]{4,2,0,7,4}, decode(new int[]{6,2,7,3}, 4));
    }

    public int[] decode(int[] encoded, int first) {
        int[] decoded = new int[encoded.length + 1];
        decoded[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            decoded[i + 1] = decoded[i] ^ encoded[i];
        }

        return decoded;
    }
}
