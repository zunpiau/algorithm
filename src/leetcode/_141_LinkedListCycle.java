package leetcode;

import common.ListNode;

public class _141_LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        for (ListNode oneStep = head, twoStep = head.next; oneStep != null && twoStep != null; oneStep = oneStep.next) {
            if (oneStep == twoStep)
                return true;
            if (twoStep.next == null)
                return false;
            twoStep = twoStep.next.next;
        }
        return false;
    }

}
