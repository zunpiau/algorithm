package leetcode;

import common.TreeNode;

public class _104_MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        return (root == null) ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}
