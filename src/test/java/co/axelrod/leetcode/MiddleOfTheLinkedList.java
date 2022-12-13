package co.axelrod.leetcode;

import co.axelrod.leetcode.list.ListNode;
import org.junit.jupiter.api.Test;

import static co.axelrod.leetcode.list.LinkedListUtil.createLinkedList;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/middle-of-the-linked-list/
 */
class MiddleOfTheLinkedList {
    @Test
    void middleNodeTest() {
        ListNode input;
        ListNode expected;

        input = createLinkedList(new Integer[]{1, 2, 3, 4, 5});
        expected = input.next.next;
        assertEquals(expected, middleNode(input));

        input = createLinkedList(new Integer[]{1, 2, 3, 4, 5, 6});
        expected = input.next.next.next;
        assertEquals(expected, middleNode(input));
    }

    public ListNode middleNode(ListNode head) {
        ListNode middle = head;

        int count = 1;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;

            if (count % 2 == 1) {
                middle = middle.next;
            }
        }

        return middle;
    }
}
