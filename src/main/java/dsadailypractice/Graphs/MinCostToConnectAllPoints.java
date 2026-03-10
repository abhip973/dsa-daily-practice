package dsadailypractice.Graphs;

import java.util.PriorityQueue;

public class MinCostToConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{0, 0});
        int edgesUsed = 0;
        int minCost = 0;
        while (edgesUsed < n) {
            int[] curr = pq.poll();
            int node = curr[0], dist = curr[1];
            if (visited[node]) continue;
            visited[node] = true;
            edgesUsed++;
            minCost += dist;
            for (int nextNode = 0; nextNode < n; nextNode++) {
                if (!visited[nextNode]) {
                    int newDist = Math.abs(points[node][0] - points[nextNode][0]) + Math.abs(points[node][1] - points[nextNode][1]);
                    pq.offer(new int[]{nextNode, newDist});
                }
            }
        }
        return minCost;
    }
}
