package dsadailypractice.Graphs;

import java.util.*;

public class NumberOfOperationsToMakeNetworkConnected {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < connections.length; i++) {
            int from = connections[i][0];
            int to = connections[i][1];
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        boolean[] visited = new boolean[n];
        int subGraphCount = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                subGraphCount++;
                bfs(i, visited, graph);
            }
        }
        return subGraphCount - 1;
    }

    public static void bfs(int start, boolean[] visited, Map<Integer, List<Integer>> graph) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {
            int curr = q.poll();
            List<Integer> currNeigh = graph.get(curr);
            for (int i = 0; i < currNeigh.size(); i++) {
                if (!visited[currNeigh.get(i)]) {
                    visited[currNeigh.get(i)] = true;
                    q.offer(currNeigh.get(i));
                }
            }
        }
    }
}
