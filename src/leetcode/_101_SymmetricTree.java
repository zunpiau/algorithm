package leetcode;

import common.TreeNode;

public class _101_SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        return left == null && right == null
                || left != null && right != null && left.val == right.val && isSymmetric(left.right, right.left) && isSymmetric(left.left, right.right);
    }

}
