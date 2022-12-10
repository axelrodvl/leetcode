package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/richest-customer-wealth/
 */
class RichestCustomerWealth {
    @Test
    void maximumWealthTest() {
        assertEquals(6, maximumWealth(new int[][]{
                {1, 2, 3},
                {3, 2, 1}
        }));

        assertEquals(10, maximumWealth(new int[][]{
                {1, 5},
                {7, 3},
                {3, 5}
        }));
    }

    public int maximumWealth(int[][] accounts) {
        int max = -1;
        for (int i = 0; i < accounts.length; i++) {
            int current = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                current += accounts[i][j];
            }
            if (current > max) {
                max = current;
            }
        }
        return max;
    }
}
