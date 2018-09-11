package exercise.point_to_offer;

import common.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

import static common.CommonUtil.toTree;

public class PrintTree2 {

    @Test
    public void test() {
        System.out.println(Print(toTree("1,2,3,4,5,6,7")));
        System.out.println(Print(toTree("1,2,0,3,4", 0)));
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> levels = new ArrayList<>();
        if (pRoot == null) return levels;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            int s = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            while (s-- > 0) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            levels.add(level);
        }
        return levels;
    }

}
