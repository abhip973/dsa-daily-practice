package dsadailypractice.TwoPointersAndSlidingWindow;

public class IntersectionOfTwoLinkedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //Calculate length of both Linked lists
        ListNode pA = headA;
        ListNode pB = headB;
        int lA = 0;
        int lB = 0;
        while (pA != null) {
            lA++;
            pA = pA.next;
        }
        while (pB != null) {
            lB++;
            pB = pB.next;
        }

        //Calculate difference and make ListA the longer list
        int diff = Math.abs(lA - lB);
        if (lB > lA) {
            ListNode temp = headA;
            headA = headB;
            headB = temp;
        }

        //Move ListA head so as they are equidistant from the end
        for (int i = 0; i < diff; i++) {
            headA = headA.next;
        }

        //Compare both lists
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    public ListNode getIntersectionNodeOptimized(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
