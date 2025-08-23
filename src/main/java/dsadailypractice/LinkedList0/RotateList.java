package dsadailypractice.LinkedList0;

public class RotateList {
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

    public ListNode rotateList(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        int length = 0;
        ListNode curr = head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode newHead = null;

        while (curr != null) {
            curr = curr.next;
            length++;
        }
        k = k % length;
        for (int i = 0; i < k; i++) fast = fast.next;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = head;
        newHead = slow.next;
        slow.next = null;

        return newHead;
    }
}
