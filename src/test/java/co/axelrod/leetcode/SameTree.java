package co.axelrod.leetcode;

import co.axelrod.leetcode.tree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static co.axelrod.leetcode.tree.TreeUtil.createBinaryTree;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/same-tree/
 */
class SameTree {
    @Test
    void isSameTreeTest() {
        assertTrue(isSameTree(
                createBinaryTree(new Integer[]{1, 2, 3}),
                createBinaryTree(new Integer[]{1, 2, 3})
        ));

        assertFalse(isSameTree(
                createBinaryTree(new Integer[]{1, 2}),
                createBinaryTree(new Integer[]{1, null, 2})
        ));

        assertFalse(isSameTree(
                createBinaryTree(new Integer[]{1, 2, 1}),
                createBinaryTree(new Integer[]{1, 1, 2})
        ));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        Queue<TreeNode> tree1 = new LinkedList<>(List.of(p));
        Queue<TreeNode> tree2 = new LinkedList<>(List.of(q));

        while (!tree1.isEmpty()) {
            TreeNode first = tree1.poll();
            TreeNode second = tree2.poll();
            if (first.val != second.val) {
                return false;
            }

            if (first.left != null && second.left != null) {
                tree1.add(first.left);
                tree2.add(second.left);
            } else {
                if (first.left != null || second.left != null) {
                    return false;
                }
            }

            if (first.right != null && second.right != null) {
                tree1.add(first.right);
                tree2.add(second.right);
            } else {
                if (first.right != null || second.right != null) {
                    return false;
                }
            }
        }

        return true;
    }
}
