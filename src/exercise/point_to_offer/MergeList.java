package exercise.point_to_offer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MergeList {

    @Test
    public void test() {
        ListNode list1 = new ListNode(0, new ListNode(2));
        ListNode list2 = new ListNode(1, new ListNode(3));
        ListNode merge = Merge(list1, list2);
        assertEquals(0, merge.val);
        assertEquals(1, merge.next.val);
        assertEquals(3, merge.next.next.next.val);
        assertEquals(1, Merge(null, list2).val);
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
