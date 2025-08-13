package dsadailypractice.LinkedList0;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfLinkedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();

        //Adding nodes of one list to the set
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        //Checking if nodes of 2nd list are already present in set
        while (headB != null) {
            if (set.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }
}
