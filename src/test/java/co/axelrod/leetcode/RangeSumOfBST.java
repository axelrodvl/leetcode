package co.axelrod.leetcode;

import co.axelrod.leetcode.tree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static co.axelrod.leetcode.tree.TreeUtil.createBinaryTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/range-sum-of-bst/
 */
class RangeSumOfBST {
    @Test
    void rangeSumBSTTest() {
        assertEquals(32, rangeSumBSTIterative(
                createBinaryTree(new Integer[]{10, 5, 15, 3, 7, 0, 18}),
                7, 15
        ));

        assertEquals(32, rangeSumBSTRecursive(
                createBinaryTree(new Integer[]{10, 5, 15, 3, 7, 0, 18}),
                7, 15
        ));
    }

    public int rangeSumBSTIterative(TreeNode root, int low, int high) {
        int result = 0;

        Queue<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.poll();
            if (treeNode.val >= low && treeNode.val <= high) {
                result += treeNode.val;
            }
            if (treeNode.left != null) {
                stack.add(treeNode.left);
            }
            if (treeNode.right != null) {
                stack.add(treeNode.right);
            }
        }

        return result;
    }

    public int rangeSumBSTRecursive(TreeNode root, int low, int high) {
        return root == null
                ? 0
                : (root.val >= low && root.val <= high ? root.val : 0)
                    + rangeSumBSTRecursive(root.left, low, high)
                    + rangeSumBSTRecursive(root.right, low, high);
    }
}
