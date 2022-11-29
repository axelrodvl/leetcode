package co.axelrod.leetcode;

import co.axelrod.leetcode.list.ListNode;
import org.junit.jupiter.api.Test;

import static co.axelrod.leetcode.list.LinkedListUtil.createLinkedList;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 */
class PalindromeLinkedList {
    @Test
    void isPalindromeTest() {
        assertTrue(isPalindrome(createLinkedList(new Integer[]{})));
        assertTrue(isPalindrome(createLinkedList(new Integer[]{1})));
        assertTrue(isPalindrome(createLinkedList(new Integer[]{1, 1})));
        assertTrue(isPalindrome(createLinkedList(new Integer[]{1, 0, 1})));
        assertTrue(isPalindrome(createLinkedList(new Integer[]{1, 1, 1, 1})));
        assertTrue(isPalindrome(createLinkedList(new Integer[]{1, 2, 2, 1})));
        assertTrue(isPalindrome(createLinkedList(new Integer[]{1, 2, 3, 2, 1})));
        assertTrue(isPalindrome(createLinkedList(new Integer[]{1, 2, 3, 3, 2, 1})));
        assertFalse(isPalindrome(createLinkedList(new Integer[]{1, 2, 3, 4, 5, 6})));
        assertFalse(isPalindrome(createLinkedList(new Integer[]{1, 0, 0})));
        assertFalse(isPalindrome(createLinkedList(new Integer[]{1, 2})));
        assertFalse(isPalindrome(createLinkedList(new Integer[]{1, 1, 2, 1})));
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Counting number of nodes
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }

        // Locating pointer to the "middle" node
        current = head;
        for (int i = 0; i < count / 2 - 1; i++) {
            current = current.next;
        }

        ListNode middle = current;
        current = current.next;

        // Reversing the second half of the list
        ListNode prev = null;
        ListNode next = current.next;
        while (next != null) {
            ListNode nextNext = next.next;

            current.next = prev;
            next.next = current;

            prev = current;
            current = next;
            next = nextNext;
        }

        middle.next = current;
        current = middle.next;

        // Comparing list half by half
        for (int i = 0; i < count / 2; i++) {
            if (head.val != current.val) {
                return false;
            }
            head = head.next;
            current = current.next;
        }

        return true;
    }
}
