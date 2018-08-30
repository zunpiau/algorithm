package exercise.point_to_offer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseList {

    @Test
    public void test() {
        ListNode head = new ListNode(0, new ListNode(1));
        ListNode reversed = reverse(head);
        assertEquals(1, reversed.val);
        assertEquals(0, reversed.next.val);
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
