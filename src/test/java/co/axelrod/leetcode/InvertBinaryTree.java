package co.axelrod.leetcode;

import co.axelrod.leetcode.tree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static co.axelrod.leetcode.tree.TreeUtil.createBinaryTree;
import static co.axelrod.leetcode.tree.TreeUtil.equalTree;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 */
class InvertBinaryTree {
    @Test
    void invertTreeRecursiveTest() {
        assertTrue(equalTree(
                createBinaryTree(
                        new Integer[]{2, 1, 3}),
                invertTreeRecursive(createBinaryTree(
                        new Integer[]{2, 3, 1})
                )
        ));

        assertTrue(equalTree(
                createBinaryTree(
                        new Integer[]{4, 7, 2, 9, 6, 3, 1}),
                invertTreeRecursive(createBinaryTree(
                        new Integer[]{4, 2, 7, 1, 3, 6, 9})
                )
        ));
    }

    @Test
    void invertTreeIterativeTest() {
        assertTrue(equalTree(
                createBinaryTree(
                        new Integer[]{2, 1, 3}),
                invertTreeRecursive(createBinaryTree(
                        new Integer[]{2, 3, 1})
                )
        ));

        assertTrue(equalTree(
                createBinaryTree(
                        new Integer[]{4, 7, 2, 9, 6, 3, 1}),
                invertTreeIterative(createBinaryTree(
                        new Integer[]{4, 2, 7, 1, 3, 6, 9})
                )
        ));
    }

    public TreeNode invertTreeRecursive(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.left != null || root.right != null) {
            TreeNode save = root.left;
            root.left = root.right;
            root.right = save;

            invertTreeRecursive(root.left);
            invertTreeRecursive(root.right);
        }

        return root;
    }

    public TreeNode invertTreeIterative(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }

        return root;
    }
}
