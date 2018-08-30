package leetcode;

import common.ListNode;

public class _021_MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode node = head;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                node.next = l2;
                l2 = l2.next;
            } else {
                node.next = l1;
                l1 = l1.next;
            }
            node = node.next;
        }
        if (l1 == null) node.next = l2;
        if (l2 == null) node.next = l1;
        return head.next;
    }

    public ListNode mergeTwoLists_recursive(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head;
        if (l1.val > l2.val) {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        } else {
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        }
        return head;
    }
}
