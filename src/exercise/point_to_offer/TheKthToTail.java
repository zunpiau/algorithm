package exercise.point_to_offer;

import common.ListNode;
import org.junit.Test;

import static common.CommonUtil.toList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TheKthToTail {

    @Test
    public void test() {
        assertNull(FindKthToTail(toList("1"), 2));
        assertEquals(1, FindKthToTail(toList("1"), 1).val);
        assertEquals(4, FindKthToTail(toList("1,2,3,4"), 1).val);
        assertEquals(1, FindKthToTail(toList("1,2,3,4"), 4).val);
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) return null;
        ListNode front = head, back = head;
        for (int i = 1; i < k; i++) {
            front = front.next;
            if (front == null) return null;
        }
        while (front.next != null) {
            back = back.next;
            front = front.next;
        }
        return back;
    }

}
