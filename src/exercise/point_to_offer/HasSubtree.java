package exercise.point_to_offer;

import common.TreeNode;
import org.junit.Test;

import static common.TreeUtil.toTree;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HasSubtree {

    @Test
    public void test() {
        assertFalse(hasSubtree(null, null));
        assertFalse(hasSubtree(toTree("5"), null));
        assertTrue(hasSubtree(toTree("5"), toTree("5")));
        assertTrue(hasSubtree(toTree("5,8"), toTree("5")));
        assertFalse(hasSubtree(toTree("5"), toTree("5,8")));
        assertFalse(hasSubtree(toTree("5,8"), toTree("5,9")));
        assertTrue(hasSubtree(toTree("5,8"), toTree("8")));
    }

    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        return isSame(root1, root2) || hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2);
    }

    private boolean isSame(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;
        return root1.val == root2.val && isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
    }

}
