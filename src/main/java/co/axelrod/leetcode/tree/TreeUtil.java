package co.axelrod.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtil {
    private TreeUtil() {
        // Utility class
    }

    public static TreeNode createBinaryTree(Integer[] args) {
        if (args.length == 0) {
            return null;
        }

        int index = 0;

        TreeNode root = new TreeNode(args[index++]);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current == null) {
                index++;
                continue;
            }

            if (index < args.length) {
                current.left = args[index] == null ? null : new TreeNode(args[index]);
                queue.add(current.left);
                index++;
            }

            if (index < args.length) {
                current.right = args[index] == null ? null : new TreeNode(args[index]);
                queue.add(current.right);
                index++;
            }
        }

        return root;
    }

    public static boolean equalTree(TreeNode first, TreeNode second) {
        if (first == null && second == null) {
            return true;
        }
        if (first == null || second == null) {
            return false;
        }
        if (first.val != second.val) {
            return false;
        }
        return equalTree(first.left, second.left) && equalTree(first.right, second.right);
    }
}
