package dsadailypractice.Graphs;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class ShortestPathInWeightedGraph {
    public static int[] dijkstraAlgorithm(int[][][] graph, int src) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{src, 0});
        int[] ans = new int[graph.length];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[src] = 0;
        while (!pq.isEmpty()) {
            int[] poppedNode = pq.poll();
            int curr = poppedNode[0];
            int weight = poppedNode[1];
            if (weight > ans[curr]) continue;
            for (int i = 0; i < graph[curr].length; i++) {
                int dist = graph[curr][i][1] + weight;
                if (ans[graph[curr][i][0]] > dist) {
                    ans[graph[curr][i][0]] = dist;
                    pq.offer(new int[]{graph[curr][i][0], dist});
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][][] graph = {{{1, 2}, {2, 4}}, {{3, 7}, {2, 1}}, {{4, 3}, {5, 1}}, {{6, 1}}, {{3, 2}, {6, 5}}, {{3, 3}, {6, 8}}, {}};
        System.out.println(Arrays.toString(dijkstraAlgorithm(graph, 0)));
    }
}
