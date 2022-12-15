package co.axelrod.leetcode;

import co.axelrod.leetcode.tree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static co.axelrod.leetcode.tree.TreeUtil.createBinaryTree;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/path-sum/
 */
class PathSum {
    @Test
    void hasPathSumTest() {
        assertTrue(hasPathSum(
                createBinaryTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1}),
                22
        ));

        assertFalse(hasPathSum(
                createBinaryTree(new Integer[]{1, 2, 3}),
                5
        ));

        assertFalse(hasPathSum(
                createBinaryTree(new Integer[]{}),
                0
        ));

        assertFalse(hasPathSum(
                createBinaryTree(new Integer[]{1, 2}),
                1
        ));
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        int sum = 0;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode last = stack.peek();
            sum += last.val;
            if (last.left != null && last.left.val != Integer.MAX_VALUE) {
                stack.push(last.left);
            } else if (last.right != null && last.right.val != Integer.MAX_VALUE) {
                stack.push(last.right);
            } else {
                if (sum == targetSum && last.left == null && last.right == null) {
                    return true;
                } else {
                    sum -= last.val;
                    TreeNode current = stack.pop();
                    if (!stack.isEmpty()) {
                        TreeNode parent = stack.peek();
                        sum -= parent.val;
                        if (parent.left == current) {
                            parent.left.val = Integer.MAX_VALUE;
                        } else {
                            parent.right.val = Integer.MAX_VALUE;
                        }
                    }
                }
            }
        }

        return false;
    }
}
