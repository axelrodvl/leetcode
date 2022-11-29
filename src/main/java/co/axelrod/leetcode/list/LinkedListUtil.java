package co.axelrod.leetcode.list;

public class LinkedListUtil {
    private LinkedListUtil() {
        // Utility class
    }

    public static boolean equalLinkedList(ListNode firstListNode, ListNode secondListNode) {
        if (firstListNode == null && secondListNode == null) {
            return true;
        }

        while (firstListNode != null && secondListNode != null) {
            if (firstListNode.val != secondListNode.val) {
                return false;
            }
            if (firstListNode.next == null && secondListNode.next == null) {
                return true;
            }
            if (firstListNode.next == null) {
                return false;
            }
            if (secondListNode.next == null) {
                return false;
            }
            firstListNode = firstListNode.next;
            secondListNode = secondListNode.next;
        }

        return true;
    }

    public static ListNode createLinkedList(Integer[] args) {
        if (args.length == 0) {
            return null;
        }

        ListNode first = new ListNode(args[0]);
        ListNode current = first;
        int index = 1;
        while (index < args.length) {
            current.next = new ListNode(args[index++]);
            current = current.next;
        }

        return first;
    }
}
