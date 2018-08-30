package exercise;

import common.ListNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * http://wuchong.me/blog/2014/03/25/interview-link-questions/
 */
public class LinkedListExercise {

    private ListNode head;
    private ListNode node2;
    private ListNode node3;
    private ListNode node4;
    private ListNode head2;

    private static ListNode insert(ListNode head, int i) {
        if (head == null)
            return null;
        ListNode node = new ListNode(i, null);
        if (i < head.val) {
            node.next = head;
            return node;
        }
        ListNode current = head.next;
        ListNode pre = head;
        while (current != null && current.val < i) {
            pre = current;
            current = current.next;
        }
        node.next = current;
        pre.next = node;
        return head;
    }

    private static ListNode reverse(ListNode head) {
        if (head == null)
            return head;
        ListNode current = head;
        ListNode next = head.next;
        ListNode previous = null;
        while (next != null) {
            current.next = previous;
            previous = current;
            current = next;
            next = current.next;
        }
        current.next = previous;
        return current;
    }

    private static ListNode recursionReverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = recursionReverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    private static void remove(ListNode node) {
        assert node.next != null;
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }

    private static ListNode theKthNode(ListNode head, int k) {
        ListNode fast = head, slow = head;
        int i;
        for (i = 0; i < k && fast != null; i++) {
            fast = fast.next;
        }
        if (i < k - 1)
            return null;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    private static ListNode theMiddleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private static boolean hasCircle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }

    private static ListNode findLoopPort(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                break;
        }
        if (fast != slow) return null;
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    private static boolean isIntersect(ListNode node1, ListNode node2) {
        ListNode tail1 = node1;
        while (tail1.next != null) {
            tail1 = tail1.next;
        }
        ListNode tail2 = node2;
        while (tail2.next != null) {
            tail2 = tail2.next;
        }
        return tail1 == tail2;
    }

    private static ListNode findIntersectNode(ListNode pHead1, ListNode pHead2) {
        int l1 = length(pHead1);
        int l2 = length(pHead2);
        ListNode node1 = pHead1;
        ListNode node2 = pHead2;
        if (l1 > l2) {
            for (int i = 0; i < l1 - l2; i++) {
                node1 = node1.next;
            }
        } else {
            for (int i = 0; i < l2 - l1; i++) {
                node2 = node2.next;
            }
        }
        while (node1 != null) {
            if (node1 == node2)
                return node1;
            node1 = node1.next;
            node2 = node2.next;
        }
        return null;
    }

    private static ListNode findIntersectNodeWithLoop(ListNode head1, ListNode head2) {
        ListNode loopPort1 = findLoopPort(head1);
        ListNode loopPort2 = findLoopPort(head2);
        if (loopPort1 == loopPort2) {
            return findIntersectNode(head1, head2);
        } else if (loopPort1 == null || loopPort2 == null) {
            return null;
        } else {
            ListNode node = loopPort1.next;
            do {
                if (node == loopPort2) {
                    return loopPort1;
                }
                node = node.next;
            } while (node != loopPort1);
            return null;
        }
    }

    private static int length(ListNode head) {
        int i = 0;
        ListNode node = head;
        while (node != null) {
            i++;
            node = node.next;
        }
        return i;
    }

    private static void print(ListNode head) {
        ListNode node = head;
        while (node != null) {
            System.out.print(node);
            System.out.print(" -> ");
            node = node.next;
        }
    }

    @Before
    public void setup() {
        node4 = new ListNode(4);
        node3 = new ListNode(3, node4);
        node2 = new ListNode(2, node3);
        head = new ListNode(1, node2);
        head2 = new ListNode(11, new ListNode(12, node2));
    }

    @Test
    public void testReverse() {
        ListNode newHead = reverse(head);
        assertEquals(node4, newHead);
        assertEquals(node2, newHead.next.next);
        assertEquals(head, recursionReverse(newHead));
        assertEquals(node3, head.next.next);
    }

    @Test
    public void testRemove() {
        remove(node2);
        assertEquals(node3.val, head.next.val);
    }

    @Test
    public void testInsert() {
        remove(node2);
        head = insert(head, 2);
        assertEquals(2, head.next.val);
        assertEquals(node3.val, head.next.next.val);
    }

    @Test
    public void testKth() {
        assertEquals(node4.val, theKthNode(head, 1).val);
        assertEquals(node3.val, theKthNode(head, 2).val);
        assertEquals(node2.val, theKthNode(head, 3).val);
        assertEquals(head.val, theKthNode(head, 4).val);
    }

    @Test
    public void testMiddleNode() {
        assertEquals(node3.val, theMiddleNode(head).val);
        head = insert(head, 5);
        assertEquals(node3.val, theMiddleNode(head).val);
    }

    @Test
    public void testHasCircle() {
        assertFalse(hasCircle(head));
        node4.next = node2;
        assertTrue(hasCircle(head));
    }

    @Test
    public void testFindLoopPort() {
        node4.next = node2;
        assertEquals(node2.val, findLoopPort(head).val);
    }

    @Test
    public void testIsIntersect() {
        assertTrue(isIntersect(head, head2));
        assertFalse(isIntersect(head, new ListNode(21, new ListNode(22))));
    }

    @Test
    public void testFindIntersectNode() {
        assertEquals(node2, findIntersectNode(head, head2));
    }

}
