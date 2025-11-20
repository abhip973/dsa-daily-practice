package dsadailypractice.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRightPointersInEachNode {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connectIterativeApproach(Node root) {
        if (root == null) return root;
        Queue<Node> q1 = new LinkedList<>();
        q1.offer(root);
        while (!q1.isEmpty()) {
            int size = q1.size();
            for (int i = 0; i < size; i++) {
                Node curr = q1.poll();
                Node nextNode = q1.peek();
                if (i != size - 1) {
                    curr.next = nextNode;
                }
                if (curr.left != null) {
                    q1.offer(curr.left);
                    q1.offer(curr.right);
                }
            }
        }
        return root;
    }

    public Node connectRecursiveApproach(Node root) {
        if (root == null) return root;
        traverse(root);
        return root;
    }

    public void traverse(Node curr) {
        if (curr.left != null)
            curr.left.next = curr.right;
        if (curr.next != null && curr.right != null) {
            curr.right.next = curr.next.left;
        }
        if (curr.left != null) {
            traverse(curr.left);
            traverse(curr.right);
        }
    }
}
