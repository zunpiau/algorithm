package leetcode;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _257_BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> paths = new ArrayList<>();
        dfs(root, paths, "");
        return paths;
    }

    private void dfs(TreeNode root, ArrayList<String> paths, String prefix) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            paths.add(prefix + root.val);
            return;
        }
        prefix = prefix + root.val + "->";
        dfs(root.left, paths, prefix);
        dfs(root.right, paths, prefix);
    }
}
