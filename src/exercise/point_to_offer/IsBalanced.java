package exercise.point_to_offer;

import common.CommonUtil;
import common.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class IsBalanced {

    @Test
    public void test() {
        assertTrue(IsBalanced_Solution(null));
        assertTrue(IsBalanced_Solution(CommonUtil.toTree("0,-1,1", -1)));
        assertFalse(IsBalanced_Solution(CommonUtil.toTree("0,2,-1,3", -1)));
        assertFalse(IsBalanced_Solution(CommonUtil.toTree("0,2,-1,-1,3", -1)));
        assertTrue(IsBalanced_Solution(CommonUtil.toTree("0,2,4,-1,3", -1)));
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        return root == null
               || Math.abs(depth(root.right) - depth(root.left)) <= 1
                  && IsBalanced_Solution(root.right)
                  && IsBalanced_Solution(root.left);
    }

    private int depth(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(depth(node.left), depth(node.right));
    }

}
