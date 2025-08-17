package dsadailypractice.LinkedList0;

public class RemoveNthFromEnd {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //Approach-I (2-Pass)

        //Find the length of the linked list
        ListNode curr = head;
        int length = 0;
        while (curr != null) {
            curr = curr.next;
            length++;
        }

        ListNode sentinel = new ListNode();
        sentinel.next = head;
        ListNode prev = sentinel;
        //Move to the n-1 node
        for (int i = 0; i < length - n; i++) {
            prev = prev.next;
        }

        //Remove the node
        prev.next = prev.next.next;
        return sentinel.next;
    }

    public ListNode removeNthNodeFromEnd(ListNode head, int n) {
        //Approach-II (1-Pass)

        ListNode sentinel = new ListNode();
        sentinel.next = head;

        ListNode p1 = sentinel;
        ListNode p2 = sentinel;

        //Move pointer 2 to n position ahead
        for (int i = 0; i < n; i++) {
            p2 = p2.next;
        }

        //Move the pointers
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        //Remove the node
        p1.next = p1.next.next;

        return sentinel.next;
    }
}
