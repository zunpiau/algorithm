package common;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TreeUtil {

    public static TreeNode toTree(int[] array, int nullVal) {
        if (array == null) return null;
        return build(array, nullVal, 0);
    }

    public static TreeNode toTree(String s) {
        return toTree(s, -1);
    }

    public static TreeNode toTree(String s, int nullVal) {
        if (s == null || s.length() == 0) return null;
        String[] strings = s.split(",");
        if (strings.length == 0) return null;
        int[] array = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            array[i] = Integer.parseInt(strings[i]);
        }
        return build(array, nullVal, 0);
    }

    private static TreeNode build(int[] array, int nullVal, int pos) {
        if (pos >= array.length || array[pos] == nullVal) return null;
        TreeNode node = new TreeNode(array[pos]);
        node.left = build(array, nullVal, pos * 2 + 1);
        node.right = build(array, nullVal, pos * 2 + 2);
        return node;
    }

    @Test
    public void test() {
        assertNull(toTree((int[]) null, -1));
        assertNull(toTree(new int[0], -1));
        assertNull(toTree(new int[]{-1}, -1));
        assertEquals(5, toTree(new int[]{5}, -1).val);
        assertEquals(8, toTree(new int[]{5, 3, 8}, -1).right.val);
        assertEquals(9, toTree(new int[]{5, 3, -1, 4, 9}, -1).left.right.val);

        assertNull(toTree("5", 5));
        assertEquals(5, toTree("5").val);
        assertEquals(8, toTree("5,3,8").right.val);
        assertEquals(9, toTree("5,3,4,-1,9").left.right.val);
    }

}
