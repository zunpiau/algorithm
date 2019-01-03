package exercise.point_to_offer;

import common.TreeNode;
import org.junit.Test;

import java.util.ArrayList;

import static common.CommonUtil.toTree;
import static org.junit.Assert.assertEquals;

public class FindPathInTree {

    private static void findPath(TreeNode root, int target, ArrayList<Integer> path,
            ArrayList<ArrayList<Integer>> paths) {
        if (root == null) return;
        target -= root.val;
        path.add(root.val);
        if (target == 0 && root.left == null && root.right == null)
            paths.add(new ArrayList<>(path));
        findPath(root.left, target, path, paths);
        findPath(root.right, target, path, paths);
        path.remove(path.size() - 1);
    }

    @Test
    public void test() {
        FindPathInTree finder = new FindPathInTree();
        assertEquals("[[1, 3, 6]]", String.valueOf(finder.FindPath(toTree("1,2,3,4,5,6"), 10)));
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        findPath(root, target, path, paths);
        return paths;
    }

}
