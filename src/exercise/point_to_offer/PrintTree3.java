package exercise.point_to_offer;

import common.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

import static common.CommonUtil.toTree;

public class PrintTree3 {

    @Test
    public void test() {
        System.out.println(Print(toTree("1,2,3,4,5,6,7,8,9")));
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> levels = new ArrayList<>();
        if (pRoot == null) return levels;
        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();
        queue1.add(pRoot);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            boolean rtl = queue1.isEmpty();
            LinkedList<TreeNode> queue = rtl ? queue2 : queue1;
            LinkedList<TreeNode> nextQueue = rtl ? queue1 : queue2;
            ArrayList<Integer> level = new ArrayList<>();
            int s = queue.size();
            while (s-- > 0) {
                TreeNode node = queue.pollLast();
                level.add(node.val);
                if (rtl) {
                    if (node.right != null) nextQueue.add(node.right);
                    if (node.left != null) nextQueue.add(node.left);
                } else {
                    if (node.left != null) nextQueue.add(node.left);
                    if (node.right != null) nextQueue.add(node.right);
                }
            }
            levels.add(level);
        }
        return levels;
    }

}
