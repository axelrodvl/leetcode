package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time/
 */
class NumberOfStudentsDoingHomeworkAtAGivenTime {
    @Test
    void busyStudentTest() {
        assertEquals(1, busyStudent(new int[]{1,2,3}, new int[]{3,2,7}, 4));
        assertEquals(1, busyStudent(new int[]{4}, new int[]{4}, 4));
    }

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                count++;
            }
        }
        return count;
    }
}
