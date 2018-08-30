package leetcode;

import common.TreeNode;

public class _437_PathSumIII {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumWithRoot(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int pathSumWithRoot(TreeNode root, int sum) {
        if (root == null) return 0;
        return (root.val == sum ? 1 : 0) + pathSumWithRoot(root.left, sum - root.val) + pathSumWithRoot(root.right, sum - root.val);
    }

}
