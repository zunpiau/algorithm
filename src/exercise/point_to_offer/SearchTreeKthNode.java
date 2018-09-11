package exercise.point_to_offer;

import common.TreeNode;
import org.junit.Test;

import java.util.LinkedList;

import static common.CommonUtil.toTree;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SearchTreeKthNode {

    @Test
    public void test() {
        assertEquals(4, KthNode(toTree("5,3,7,2,4,6,8"), 3).val);
        assertNull(KthNode(toTree("5,3,7,2,4,6,8"), 0));
        assertNull(KthNode(toTree("5,3,7,2,4,6,8"), 8));
        assertNull(KthNode(toTree(""), 0));
    }

    TreeNode KthNode(TreeNode pRoot, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode node = pRoot;
        int i = 1;
        while (node != null || !stack.isEmpty()) {
            if (node == null) {
                node = stack.pop();
                if (i++ == k) return node;
                node = node.right;
            } else {
                stack.push(node);
                node = node.left;
            }
        }
        return null;
    }

}
