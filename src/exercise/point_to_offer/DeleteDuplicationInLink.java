package exercise.point_to_offer;

import common.ListNode;
import org.junit.Test;

import static common.CommonUtil.toArray;
import static common.CommonUtil.toList;
import static org.junit.Assert.assertArrayEquals;

public class DeleteDuplicationInLink {

    @Test
    public void test() {
        ListNode head;
        head = deleteDuplication(toList("1,2,2,3,3,3,4,5"));
        assertArrayEquals(new int[]{1, 4, 5}, toArray(head));

        head = deleteDuplication(toList("1,1,2,2,3,3,4,5,5"));
        assertArrayEquals(new int[]{4}, toArray(head));

        head = deleteDuplication(toList("1"));
        assertArrayEquals(new int[]{1}, toArray(head));

        head = deleteDuplication(toList("1,1"));
        assertArrayEquals(new int[]{}, toArray(head));
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) return null;
        ListNode dummyHead = new ListNode(Integer.MAX_VALUE);
        dummyHead.next = pHead;

        ListNode pre = dummyHead, node = pHead;
        while (node != null && node.next != null) {
            ListNode next = node.next;
            if (next.val == node.val) {
                while (next != null && next.val == node.val)
                    next = next.next;
                pre.next = next;
                node = pre.next;
            } else {
                pre = pre.next;
                node = node.next;
            }
        }
        return dummyHead.next;
    }

}
