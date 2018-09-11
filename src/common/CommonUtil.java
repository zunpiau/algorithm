package common;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CommonUtil {

    public static int[] toArray(ListNode node) {
        int[] array = new int[lengthOfList(node)];
        for (int i = 0; i < array.length; i++, node = node.next) {
            array[i] = node.val;
        }
        return array;
    }

    private static int lengthOfList(ListNode node) {
        int l = 0;
        while (node != null) {
            l++;
            node = node.next;
        }
        return l;
    }

    public static ListNode toList(String s) {
        int[] array = toIntArray(s);
        if (array == null) return null;
        return toList(array);
    }

    public static ListNode toList(int[] array) {
        ListNode head = new ListNode(array[0]);
        ListNode node = head;
        for (int i = 1; i < array.length; i++) {
            node.next = new ListNode(array[i]);
            node = node.next;
        }
        return head;
    }

    public static TreeNode toTree(int[] array, int nullVal) {
        if (array == null) return null;
        return build(array, nullVal, 0);
    }

    public static TreeNode toTree(String s) {
        return toTree(s, -1);
    }

    public static TreeNode toTree(String s, int nullVal) {
        int[] array = toIntArray(s);
        if (array == null) return null;
        return build(array, nullVal, 0);
    }

    private static int[] toIntArray(String s) {
        if (s == null || s.length() == 0) return null;
        String[] strings = s.split(",");
        if (strings.length == 0) return null;
        int[] array = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            array[i] = Integer.parseInt(strings[i]);
        }
        return array;
    }

    private static TreeNode build(int[] array, int nullVal, int pos) {
        if (pos >= array.length || array[pos] == nullVal) return null;
        TreeNode node = new TreeNode(array[pos]);
        node.left = build(array, nullVal, pos * 2 + 1);
        node.right = build(array, nullVal, pos * 2 + 2);
        return node;
    }

    @Test
    public void testList() {
        assertNull(toList(""));
        assertEquals(1, toList("1").val);
        assertEquals(5, toList("1,5").next.val);
        assertNull(toList("1,5").next.next);
    }

    @Test
    public void testTree() {
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
