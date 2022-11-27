package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static co.axelrod.leetcode.array.matrix.MatrixUtil.matrixIsEqual;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/merge-intervals/
 */
public class MergeIntervals {
    @Test
    void mergeTest() {
        assertTrue(matrixIsEqual(
                new int[][]{
                        {1, 6},
                        {8, 10},
                        {15, 18}
                },
                merge(new int[][]{
                        {1, 3},
                        {2, 6},
                        {8, 10},
                        {15, 18}
                })
        ));

        assertTrue(matrixIsEqual(
                new int[][]{
                        {1, 5}
                },
                merge(new int[][]{
                        {1, 4},
                        {4, 5}
                })
        ));
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty()) {
                merged.add(interval);
            } else {
                int[] last = merged.get(merged.size() - 1);
                if (interval[0] > last[1]) {
                    merged.add(interval);
                } else {
                    last[0] = Math.min(interval[0], last[0]);
                    last[1] = Math.max(interval[1], last[1]);
                }
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
