package exercise;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TreeToInfixNotation {

    public static String toNotation(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        if (root.val == '+' || root.val == '*') {
            sb.append(toNotationWithBrackets(root.left))
                    .append(root.val)
                    .append(toNotationWithBrackets(root.right));
            return sb.toString();
        } else {
            return String.valueOf(root.val);
        }
    }

    private static String toNotationWithBrackets(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root.val == '+' || root.val == '*') {
            sb.append('(')
                    .append(toNotationWithBrackets(root.left))
                    .append(root.val)
                    .append(toNotationWithBrackets(root.right))
                    .append(')');
            return sb.toString();
        } else {
            return String.valueOf(root.val);
        }
    }

    @Test
    public void test() {
        assertEquals("", toNotation(null));
        assertEquals("1", toNotation(new TreeNode('1')));
        assertEquals("1+2", toNotation(new TreeNode('+', new TreeNode('1'), new TreeNode('2'))));
        assertEquals("(1+2)*3", toNotation(new TreeNode('*',
                new TreeNode('+', new TreeNode('1'), new TreeNode('2')),
                new TreeNode('3'))));
    }

    static class TreeNode {

        public char val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(char val) {
            this.val = val;
        }

        TreeNode(char val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
