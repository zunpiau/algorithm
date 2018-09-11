package exercise.point_to_offer;

import common.ListNode;
import org.junit.Test;

import static common.CommonUtil.toArray;
import static common.CommonUtil.toList;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

public class MergeList {

    @Test
    public void test() {
        assertArrayEquals(new int[]{0, 1, 2, 3}, toArray(Merge(toList("0,2"), toList("1,3"))));
        assertArrayEquals(new int[]{1, 3}, toArray(Merge(null, toList("1,3"))));
        assertNull(Merge(null, null));
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode node = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }
        if (list1 != null) {
            node.next = list1;
        }
        if (list2 != null) {
            node.next = list2;
        }
        return head.next;
    }

}
