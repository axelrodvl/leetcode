package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://leetcode.com/problems/flipping-an-image/
 */
class FlippingAnImage {
    @Test
    void flipAndInvertImageTest() {
        assertArrayEquals(new int[][]{
                        {1,0,0},
                        {0,1,0},
                        {1,1,1}
                },
                flipAndInvertImage(new int[][]{
                        {1,1,0},
                        {1,0,1},
                        {0,0,0}
                })
        );

        assertArrayEquals(new int[][]{
                        {1,1,0,0},
                        {0,1,1,0},
                        {0,0,0,1},
                        {1,0,1,0}
                },
                flipAndInvertImage(new int[][]{
                        {1,1,0,0},
                        {1,0,0,1},
                        {0,1,1,1},
                        {1,0,1,0}
                })
        );
    }

    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image.length; j++) {
                image[i][j] = image[i][j] == 1 ? 0 : 1;
            }
            for (int j = 0; j < image.length / 2; j++) {
                int temp = image[i][j];
                image[i][j] = image[i][image.length - j - 1];
                image[i][image.length - j - 1] = temp;
            }
        }

        return image;
    }
}
