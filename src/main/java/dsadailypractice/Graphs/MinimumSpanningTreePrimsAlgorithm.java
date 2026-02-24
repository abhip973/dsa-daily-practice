package dsadailypractice.Graphs;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumSpanningTreePrimsAlgorithm {
    public static int primsAlgorithm(int[][][] edges, int nodes) {
        boolean[] visited = new boolean[nodes];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{0, 0});
        int ans = 0;
        int nodesVisited = 0;
        while (!pq.isEmpty() && nodesVisited < nodes) {
            int[] curr = pq.poll();
            if (visited[curr[0]]) continue;
            visited[curr[0]] = true;
            ans += curr[1];
            nodesVisited++;
            for (int i = 0; i < edges[curr[0]].length; i++) {
                if (!visited[edges[curr[0]][i][0]]) {
                    pq.offer(new int[]{edges[curr[0]][i][0], edges[curr[0]][i][1]});
                }
            }
        }
        return nodesVisited == nodes ? ans : 0;
    }

    public static void main(String[] args) {
        int[][][] edges = new int[][][]{{{1, 4}, {2, 2}, {3, 5}}, {{0, 4}, {3, 1}}, {{0, 2}, {3, 3}}, {{1, 1}, {2, 3}}};
        System.out.println(primsAlgorithm(edges, 4));
    }
}
