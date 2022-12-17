package co.axelrod.leetcode;

import co.axelrod.leetcode.list.ListNode;
import org.junit.jupiter.api.Test;

import static co.axelrod.leetcode.list.LinkedListUtil.createLinkedList;
import static co.axelrod.leetcode.list.LinkedListUtil.equalLinkedList;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/remove-linked-list-elements/
 */
class RemoveLinkedListElements {
    @Test
    void removeElementsTest() {
        assertTrue(equalLinkedList(
                createLinkedList(new Integer[]{1,2,3,4,5}),
                removeElements(createLinkedList(new Integer[]{1,2,6,3,4,5,6}), 6))
        );
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        while (head != null && head.val == val) {
            head = head.next;
        }

        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            if (current.val == val) {
                prev.next = current.next;
            } else {
                prev = current;
            }
            current = current.next;
        }

        return head;
    }
}
