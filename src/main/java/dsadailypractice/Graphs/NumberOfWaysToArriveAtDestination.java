package dsadailypractice.Graphs;

import java.util.*;

public class NumberOfWaysToArriveAtDestination {
    public int countPaths(int n, int[][] roads) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        int MOD = (int) 1e9 + 7;
        for (int i = 0; i < roads.length; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            int w = roads[i][2];
            map.get(u).add(new int[]{v, w});
            map.get(v).add(new int[]{u, w});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{0, 0});
        long[] minWt = new long[n];
        Arrays.fill(minWt, Long.MAX_VALUE);
        minWt[0] = 0;
        int[] pc = new int[n];
        Arrays.fill(pc, 0);
        pc[0] = 1;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currNode = curr[0];
            long currWt = curr[1];
            List<int[]> neigh = map.get(currNode);
            for (int i = 0; i < neigh.size(); i++) {
                long neighWt = neigh.get(i)[1];
                int neighNode = neigh.get(i)[0];
                long totalWt = neighWt + currWt;
                if (totalWt < minWt[neighNode]) {
                    minWt[neighNode] = totalWt;
                    pq.offer(new int[]{neighNode, (int) totalWt});
                    pc[neighNode] = pc[currNode];
                } else if (totalWt == minWt[neighNode]) {
                    pc[neighNode] = (pc[neighNode] + pc[currNode]) % MOD;
                }
            }
        }
        return pc[n - 1];
    }
}
