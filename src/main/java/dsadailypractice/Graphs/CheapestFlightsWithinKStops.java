package dsadailypractice.Graphs;

import java.util.*;

public class CheapestFlightsWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < flights.length; i++) {
            int from = flights[i][0], to = flights[i][1], wt = flights[i][2];
            map.get(from).add(new int[]{to, wt});
        }
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[src] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0, 0});
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int currNode = curr[0], wt = curr[1], level = curr[2];
            if (level > k) continue;
            List<int[]> neigh = map.get(currNode);
            for (int i = 0; i < neigh.size(); i++) {
                if (neigh.get(i)[1] + wt < minCost[neigh.get(i)[0]]) {
                    minCost[neigh.get(i)[0]] = neigh.get(i)[1] + wt;
                    q.offer(new int[]{neigh.get(i)[0], minCost[neigh.get(i)[0]], level + 1});
                }
            }
        }
        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }
}
