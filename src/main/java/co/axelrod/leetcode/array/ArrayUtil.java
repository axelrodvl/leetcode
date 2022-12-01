package co.axelrod.leetcode.array;

public class ArrayUtil {
    private ArrayUtil() {
        // Utility class
    }

    public static boolean arrayEquals(int[] first, int[] second) {
        if (first.length != second.length) {
            return false;
        }

        for (int i = 0; i < first.length; i++) {
            if (first[i] != second[i]) {
                return false;
            }
        }

        return true;
    }
}
