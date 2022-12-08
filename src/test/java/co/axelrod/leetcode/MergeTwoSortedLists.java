package co.axelrod.leetcode;

import co.axelrod.leetcode.list.ListNode;
import org.junit.jupiter.api.Test;

import static co.axelrod.leetcode.list.LinkedListUtil.createLinkedList;
import static co.axelrod.leetcode.list.LinkedListUtil.equalLinkedList;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
class MergeTwoSortedLists {
    @Test
    void mergeTwoListsTest() {
        assertTrue(equalLinkedList(
                createLinkedList(new Integer[]{}),
                mergeTwoLists(
                        createLinkedList(new Integer[]{}),
                        createLinkedList(new Integer[]{})
                )
        ));

        assertTrue(equalLinkedList(
                createLinkedList(new Integer[]{0}),
                mergeTwoLists(
                        createLinkedList(new Integer[]{}),
                        createLinkedList(new Integer[]{0})
                )
        ));

        assertTrue(equalLinkedList(
                createLinkedList(new Integer[]{1, 1, 2, 3, 4, 4}),
                mergeTwoLists(
                        createLinkedList(new Integer[]{1, 2, 4}),
                        createLinkedList(new Integer[]{1, 3, 4})
                )
        ));

        assertTrue(equalLinkedList(
                createLinkedList(new Integer[]{1, 2, 3, 4}),
                mergeTwoLists(
                        createLinkedList(new Integer[]{1, 3, 4}),
                        createLinkedList(new Integer[]{2})
                )
        ));

        assertTrue(equalLinkedList(
                createLinkedList(new Integer[]{1, 2, 3, 4}),
                mergeTwoLists(
                        createLinkedList(new Integer[]{1}),
                        createLinkedList(new Integer[]{2, 3, 4})
                )
        ));

        assertTrue(equalLinkedList(
                createLinkedList(new Integer[]{1, 2, 3, 4, 5, 6}),
                mergeTwoLists(
                        createLinkedList(new Integer[]{2, 4, 6}),
                        createLinkedList(new Integer[]{1, 3, 5})
                )
        ));

        assertTrue(equalLinkedList(
                createLinkedList(new Integer[]{1, 2, 4, 5}),
                mergeTwoLists(
                        createLinkedList(new Integer[]{5}),
                        createLinkedList(new Integer[]{1, 2, 4})
                )
        ));

        assertTrue(equalLinkedList(
                createLinkedList(new Integer[]{-10, -9, -6, -5, -4, -3, 0, 1, 7, 8, 8, 9, 9}),
                mergeTwoLists(
                        createLinkedList(new Integer[]{-10, -9, -6, -4, 1, 9, 9}),
                        createLinkedList(new Integer[]{-5, -3, 0, 7, 8, 8})
                )
        ));
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode currentHead = null;

        while (list1 != null || list2 != null) {
            ListNode current;

            if (list1 == null) {
                current = list2;
                list2 = list2.next;
            } else if (list2 == null) {
                current = list1;
                list1 = list1.next;
            } else {
                if (list1.val < list2.val) {
                    current = list1;
                    list1 = list1.next;
                } else {
                    current = list2;
                    list2 = list2.next;
                }
            }

            if (currentHead == null) {
                currentHead = current;
                head = currentHead;
            } else {
                currentHead.next = current;
                currentHead = currentHead.next;
            }
        }

        return head;
    }
}
