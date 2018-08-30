package exercise.point_to_offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class PrintListFromTailToHead {

    @Test
    public void test() {
        assertArrayEquals(new int[]{}, toArray(printListFromTailToHead(null)));
        assertArrayEquals(new int[]{0}, toArray(printListFromTailToHead(new ListNode(0))));
        assertArrayEquals(new int[]{1, 0}, toArray(printListFromTailToHead(new ListNode(0, new ListNode(1)))));
    }

    private int[] toArray(List<Integer> list) {
        if (list == null) return null;
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        add(listNode, arrayList);
        return arrayList;
    }

    private void add(ListNode node, ArrayList<Integer> list) {
        if (node == null) return;
        add(node.next, list);
        list.add(node.val);
    }

}
