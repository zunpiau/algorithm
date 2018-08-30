package leetcode;

import common.ListNode;

public class _206_ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode newHead = null, next;
        while (head != null) {
            next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

}
