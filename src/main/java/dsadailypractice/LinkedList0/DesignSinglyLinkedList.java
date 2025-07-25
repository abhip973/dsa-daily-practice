package dsadailypractice.LinkedList0;

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class DesignSinglyLinkedList {
    public static void main(String[] args) {
        Node node1 = new Node(10);
        Node node2 = new Node(20);
        Node node3 = new Node(30);
        node1.next = node2;
        node2.next = node3;
        Node current = node1;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }
}
