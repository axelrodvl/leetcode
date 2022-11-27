package co.axelrod.leetcode;

import co.axelrod.leetcode.list.ListNode;
import org.junit.jupiter.api.Test;

import static co.axelrod.leetcode.list.LinkedListUtil.createLinkedList;
import static co.axelrod.leetcode.list.LinkedListUtil.equalLinkedList;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 */
class ReverseLinkedList {
    @Test
    void reverseListTest() {
        ListNode input = createLinkedList(new Integer[]{});
        ListNode expectedOutput = createLinkedList(new Integer[]{});
        ListNode output = reverseList(input);
        assertTrue(equalLinkedList(expectedOutput, output));

        input = createLinkedList(new Integer[]{1});
        expectedOutput = createLinkedList(new Integer[]{1});
        output = reverseList(input);
        assertTrue(equalLinkedList(expectedOutput, output));

        input = createLinkedList(new Integer[]{1, 2});
        expectedOutput = createLinkedList(new Integer[]{2, 1});
        output = reverseList(input);
        assertTrue(equalLinkedList(expectedOutput, output));

        input = createLinkedList(new Integer[]{1, 2, 3});
        expectedOutput = createLinkedList(new Integer[]{3, 2, 1});
        output = reverseList(input);
        assertTrue(equalLinkedList(expectedOutput, output));
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode previous = null;
        ListNode current = head;
        ListNode next = head.next;

        while (next != null) {
            ListNode nextNext = next.next;

            current.next = previous;
            next.next = current;

            previous = current;
            current = next;
            next = nextNext;
        }

        return current;
    }
}