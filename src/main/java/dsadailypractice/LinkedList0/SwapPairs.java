package dsadailypractice.LinkedList0;

public class SwapPairs {
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

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode sentinel = new ListNode();
        sentinel.next = head;
        ListNode p = sentinel;
        ListNode c = head;
        ListNode n = head.next;
        while (c != null && n != null) {
            c.next = n.next;
            n.next = c;
            p.next = n;
            p = c;
            c = c.next;
            n = (c != null) ? c.next : null;
        }
        return sentinel.next;
    }

    public ListNode ListNodeRecursiveApproach(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}
