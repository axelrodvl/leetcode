package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/maximum-enemy-forts-that-can-be-captured/
 */
class MaximumEnemyFortsThatCanBeCaptured {
    @Test
    void captureFortsTest() {
        assertEquals(4, captureForts(new int[]{1,0,0,-1,0,0,0,0,1}));
        assertEquals(0, captureForts(new int[]{0,0,1,-1}));
        assertEquals(2, captureForts(new int[]{1,0,0,-1,0,-1,0,0,1}));
    }

    public int captureForts(int[] forts) {
        int longestPath = 0;
        int path = 0;
        for (int i = 0; i < forts.length; i++) {
            if (forts[i] == 1) {
                // move left
                path = 0;
                for (int j = i - 1; j >= 0; j--) {
                    if (forts[j] == 1) {
                        break;
                    }
                    if (forts[j] == 0) {
                        path++;
                    }
                    if (forts[j] == -1) {
                        if (path > longestPath) {
                            longestPath = path;
                        }
                        break;
                    }
                }

                // move right
                path = 0;
                for (int j = i + 1; j < forts.length; j++) {
                    if (forts[j] == 1) {
                        break;
                    }
                    if (forts[j] == 0) {
                        path++;
                    }
                    if (forts[j] == -1) {
                        if (path > longestPath) {
                            longestPath = path;
                        }
                        break;
                    }
                }
            }
        }
        return longestPath;
    }
}
