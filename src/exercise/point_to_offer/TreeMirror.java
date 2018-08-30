package exercise.point_to_offer;

import common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class TreeMirror {

    @Test
    public void test() {
        TreeNode root = null;
        Mirror(root);
        Assert.assertNull(root);
        root = new TreeNode(null, null);
        TreeNode left = new TreeNode();
        root.left = left;
        Mirror(root);
        Assert.assertEquals(root.right, left);
        Mirror(root);
        TreeNode leftRight = new TreeNode();
        root.left.right = leftRight;
        Mirror(root);
        Assert.assertEquals(root.right.left, leftRight);
    }

    public void Mirror(TreeNode root) {
        if (root == null) return;
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        Mirror(root.left);
        Mirror(root.right);
    }

}
