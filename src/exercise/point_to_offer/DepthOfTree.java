package exercise.point_to_offer;

import common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class DepthOfTree {

    private static int TreeDepthRecursive(TreeNode root) {
        if (root == null) return 0;
        return Math.max(TreeDepthRecursive(root.left), TreeDepthRecursive(root.right)) + 1;
    }

    // TODO 非递归
    private static int TreeDepth(TreeNode root) {
        if (root == null) return 0;

        return 0;
    }

    @Test
    public void test() {
        Assert.assertEquals(0, TreeDepthRecursive(null));
        TreeNode root = new TreeNode(null, null);
        Assert.assertEquals(1, TreeDepthRecursive(root));
        root.left = new TreeNode();
        Assert.assertEquals(2, TreeDepthRecursive(root));
    }

}
