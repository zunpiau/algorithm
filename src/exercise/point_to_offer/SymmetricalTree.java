package exercise.point_to_offer;

import common.TreeNode;

public class SymmetricalTree {

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        return isMirror(pRoot.left, pRoot.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (right == null && left == null) return true;
        if (right == null || left == null) return false;
        return left.val == right.val && isMirror(left.right, right.left) && isMirror(left.left, right.right);
    }

}
