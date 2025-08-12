package dsadailypractice.LinkedList0;

public class PalindromeLinkedList {
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

    public boolean isPalindrome(ListNode head) {
        //Step 1: Find the middle node
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //Step 2: Reverse the 2nd half of linked list
        ListNode prev = null;
        ListNode curr = slow;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        //Step 3: Compare values of both lists
        ListNode firstList = head;
        ListNode secondList = prev;
        while (secondList != null) {
            if (firstList.val != secondList.val)
                return false;
            firstList = firstList.next;
            secondList = secondList.next;
        }
        return true;
    }
}
