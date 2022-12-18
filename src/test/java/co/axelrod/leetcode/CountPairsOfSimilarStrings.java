package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/count-pairs-of-similar-strings/
 */
class CountPairsOfSimilarStrings {
    @Test
    void similarPairsTest() {
        assertEquals(2, similarPairs(new String[]{"aba","aabb","abcd","bac","aabc"}));
        assertEquals(3, similarPairs(new String[]{"aabb","ab","ba"}));
        assertEquals(0, similarPairs(new String[]{"nba","cba","dba"}));
    }

    public int similarPairs(String[] words) {
        boolean[][] letters = new boolean[100][26];
        int wordsCount = 0;
        for (String word : words) {
            for (Character c : word.toCharArray()) {
                letters[wordsCount][c - 'a'] = true;
            }
            wordsCount++;
        }

        int count = 0;
        for (int i = 0; i < wordsCount; i++) {
            for (int j = i; j < wordsCount; j++) {
                if (i != j) {
                    boolean equalString = true;
                    for (int k = 0; k < 26; k++) {
                        if (letters[i][k] != letters[j][k]) {
                            equalString = false;
                            break;
                        }
                    }
                    if (equalString) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
