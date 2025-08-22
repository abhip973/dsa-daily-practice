package dsadailypractice.LinkedList0;

public class AddTwoNumbers {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        int carry = 0;
        ListNode sentinel = new ListNode();
        ListNode newHead = sentinel;
        while (l1 != null || l2 != null || carry != 0) {
            sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            carry = sum / 10;
            int digit = sum % 10;
            ListNode newNode = new ListNode(digit);
            sentinel.next = newNode;
            sentinel = newNode;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return newHead.next;
    }
}
