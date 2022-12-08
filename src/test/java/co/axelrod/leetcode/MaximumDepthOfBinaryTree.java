package co.axelrod.leetcode;

import co.axelrod.leetcode.tree.TreeNode;
import org.junit.jupiter.api.Test;

import static co.axelrod.leetcode.tree.TreeUtil.createBinaryTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
class MaximumDepthOfBinaryTree {
    @Test
    void maxDepthTest() {
        assertEquals(3, maxDepth(
                createBinaryTree(new Integer[]{3, 9, 20, 6, 6, 15, 7}))
        );

        assertEquals(2, maxDepth(
                createBinaryTree(new Integer[]{1, 2, 3}))
        );
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
