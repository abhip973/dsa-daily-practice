package dsadailypractice.Graphs;

import java.util.*;

public class ShortestPathInUnweightedGraph {
    public int[] shortestPathBFS(int[][] graph, int src, int dest) {
        int[] shortestPath = new int[graph.length];
        Arrays.fill(shortestPath, -1);
        int[] path = new int[graph.length];
        Arrays.fill(path, -1);
        shortestPath[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int i = 0; i < graph[curr].length; i++) {
                if (shortestPath[graph[curr][i]] == -1) {
                    shortestPath[graph[curr][i]] = shortestPath[curr] + 1;
                    path[graph[curr][i]] = curr;
                    q.offer(graph[curr][i]);
                }
            }
        }
        int curr = dest;
        if (shortestPath[dest] == -1) {
            System.out.println("No path exists");
            return shortestPath;
        }
        List<Integer> exactPath = new ArrayList<>();
        while (curr != -1) {
            exactPath.add(curr);
            curr = path[curr];
        }
        Collections.reverse(exactPath);
        System.out.println(exactPath);
        return shortestPath;
    }

    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {3}, {4}, {5}, {3}, {}};
        ShortestPathInUnweightedGraph shortestPathInUnweightedGraph = new ShortestPathInUnweightedGraph();
        System.out.println(Arrays.toString(shortestPathInUnweightedGraph.shortestPathBFS(graph, 0, 5)));
    }
}
