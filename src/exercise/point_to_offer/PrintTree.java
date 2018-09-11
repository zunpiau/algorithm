package exercise.point_to_offer;

import common.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

import static common.CommonUtil.toTree;
import static org.junit.Assert.assertArrayEquals;

public class PrintTree {

    @Test
    public void test() {
        assertArrayEquals(new Integer[]{1}, PrintFromTopToBottom(toTree("1")).toArray());
        assertArrayEquals(new Integer[]{1, 2, 3, 4}, PrintFromTopToBottom(toTree("1,2,3,4")).toArray());
        assertArrayEquals(new Integer[]{1, 2, 4}, PrintFromTopToBottom(toTree("1,2,0,4", 0)).toArray());
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> nodes = new ArrayList<>();
        if (root == null) return nodes;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            nodes.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return nodes;
    }

}
