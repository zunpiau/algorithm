package exercise.point_to_offer;

class ListNode {

    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode" +
                hashCode() +
                "{" +
                "val=" + val +
                '}';
    }
}
