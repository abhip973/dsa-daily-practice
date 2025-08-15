package dsadailypractice.LinkedList0;

public class RemoveElements {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode();
        sentinel.next = head;
        ListNode prev = sentinel;
        while (prev != null && prev.next != null) {
            if (prev.next.val == val)
                prev.next = prev.next.next;
            else
                prev = prev.next;
        }
        return sentinel.next;
    }
}
