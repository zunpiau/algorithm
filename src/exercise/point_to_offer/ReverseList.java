package exercise.point_to_offer;

import common.ListNode;
import org.junit.Test;

import static common.CommonUtil.toArray;
import static common.CommonUtil.toList;
import static org.junit.Assert.assertArrayEquals;

public class ReverseList {

    @Test
    public void test() {
        assertArrayEquals(new int[]{1, 0}, toArray(reverse(toList("0,1"))));
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode current = head, pre = null, next = head.next;
        while (next != null) {
            current.next = pre;
            pre = current;
            current = next;
            next = current.next;
        }
        current.next = pre;
        return current;
    }

}
