package dsadailypractice.Graphs;

import java.util.Arrays;

public class ShortestPathInNegativeWeightedGraph {
    public int[] bellmanFordAlgo(int[][] edges, int V, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for (int i = 0; i < V - 1; i++) {
            boolean updated = false;
            for (int[] e : edges) {
                int u = e[0], v = e[1], w = e[2];
                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    updated = true;
                    dist[v] = dist[u] + w;
                }
            }
            if (!updated) {
                break;
            }
        }
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                System.out.println("Negative Cycle Found");
                return null;
            }
        }
        return dist;
    }
}
