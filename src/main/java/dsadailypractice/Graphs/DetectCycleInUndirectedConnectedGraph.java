package dsadailypractice.Graphs;

import java.util.*;

public class DetectCycleInUndirectedConnectedGraph {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public boolean hasCycle(int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            if (!graph.containsKey(edges[i][0])) {
                graph.put(edges[i][0], new ArrayList<>());
            }
            if (!graph.containsKey(edges[i][1])) {
                graph.put(edges[i][1], new ArrayList<>());
            }
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        return dfs(0, null);
    }

    public boolean dfs(int node, Integer parent) {
        visited.add(node);
        List<Integer> list = graph.get(node);
        for (int i = 0; i < list.size(); i++) {
            int neighbor = list.get(i);
            if (!visited.contains(neighbor)) {
                if (dfs(neighbor, node))
                    return true;
            } else if (parent != neighbor) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DetectCycleInUndirectedConnectedGraph detectCycleInUndirectedConnectedGraph = new DetectCycleInUndirectedConnectedGraph();
        System.out.println(detectCycleInUndirectedConnectedGraph.hasCycle(new int[][]{{0, 1}, {1, 2}}));
        System.out.println(detectCycleInUndirectedConnectedGraph.hasCycle(new int[][]{{0, 1}, {1, 2}, {2, 0}}));
    }
}
