package exercise.point_to_offer;

import common.ListNode;
import org.junit.Test;

import java.util.ArrayList;

import static common.CommonUtil.toList;
import static org.junit.Assert.assertArrayEquals;

public class PrintListFromTailToHead {

    @Test
    public void test() {
        assertArrayEquals(new Integer[]{}, printListFromTailToHead(null).toArray());
        assertArrayEquals(new Integer[]{0}, printListFromTailToHead(toList("0")).toArray());
        assertArrayEquals(new Integer[]{1, 0}, printListFromTailToHead(toList("0,1")).toArray());
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
