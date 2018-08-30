package leetcode;

import common.ListNode;

public class _083_RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates_recursive(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates_recursive(head.next);
        return head.val == head.next.val ? head.next : head;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = head;
        while (node.next != null) {
            if (node.val == node.next.val)
                node.next = node.next.next;
            else
                node = node.next;
        }
        return head;
    }

}
