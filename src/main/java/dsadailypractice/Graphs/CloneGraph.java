package dsadailypractice.Graphs;

import java.util.*;

public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node root) {
        if (root == null) return root;
        Queue<Node> q = new LinkedList<>();
        Map<Node, Node> visited = new HashMap<>();
        q.offer(root);
        visited.put(root, new Node(root.val));
        while (!q.isEmpty()) {
            Node curr = q.poll();
            Node clonedCurr = visited.get(curr);
            for (Node n : curr.neighbors) {
                if (!visited.containsKey(n)) {
                    q.offer(n);
                    visited.put(n, new Node(n.val));
                }
                clonedCurr.neighbors.add(visited.get(n));
            }
        }
        return visited.get(root);
    }
}
