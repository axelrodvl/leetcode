package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/pascals-triangle-ii/
 */
class PascalTriangle2 {
    @Test
    void generateTest() {
        assertEquals(List.of(1), getRow(0));
        assertEquals(List.of(1, 1), getRow(1));
        assertEquals(List.of(1, 2, 1), getRow(2));
        assertEquals(List.of(1, 3, 3, 1), getRow(3));
        assertEquals(List.of(1, 4, 6, 4, 1), getRow(4));
    }

    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return List.of(1);
        }

        List<Integer> previous = List.of(1, 1);
        List<Integer> current;
        while (--rowIndex > 0) {
            current = new ArrayList<>();
            current.add(1);

            for (int i = 0; i < previous.size() - 1; i++) {
                current.add(previous.get(i) + previous.get(i + 1));
            }

            current.add(1);
            previous = current;
        }

        return previous;
    }
}
