package common;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        this(x, null);
    }

    public ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode@" +
                hashCode() +
                "{" +
                "val=" + val +
                '}';
    }
}
