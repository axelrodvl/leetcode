package co.axelrod.leetcode;

import co.axelrod.leetcode.tree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static co.axelrod.leetcode.tree.TreeUtil.createBinaryTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/sum-of-left-leaves/
 */
class SumOfLeftLeaves {
    @Test
    void sumOfLeftLeavesTest() {
        assertEquals(24, sumOfLeftLeaves(createBinaryTree(
                new Integer[]{3, 9, 20, null, null, 15, 7}
        )));

        assertEquals(0, sumOfLeftLeaves(createBinaryTree(
                new Integer[]{1}
        )));

        assertEquals(4, sumOfLeftLeaves(createBinaryTree(
                new Integer[]{1, 2, 3, 4, 5}
        )));
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>(List.of(root));

        int sum = 0;

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current.left != null) {
                queue.add(current.left);
                boolean isLeftLeaf = current.left.left == null && current.left.right == null;
                if (isLeftLeaf) {
                    sum += current.left.val;
                }
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }

        return sum;
    }
}
