package common;

public class TreeNode {

    public int val = 0;
    public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode() {
    }
}
