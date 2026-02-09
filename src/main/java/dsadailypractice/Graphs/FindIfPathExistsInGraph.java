package dsadailypractice.Graphs;

import java.util.*;

public class FindIfPathExistsInGraph {
    public boolean validPath(int n, int[][] edges, int src, int dest) {
        if (src == dest) return true;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int zero = edges[i][0];
            int first = edges[i][1];
            if (map.containsKey(zero)) {
                List<Integer> li = map.get(zero);
                li.add(first);
                map.put(zero, li);
            } else {
                List<Integer> li = new ArrayList<>();
                li.add(first);
                map.put(zero, li);
            }
            if (map.containsKey(first)) {
                List<Integer> li = map.get(first);
                li.add(zero);
                map.put(first, li);
            } else {
                List<Integer> li = new ArrayList<>();
                li.add(zero);
                map.put(first, li);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        Set<Integer> visited = new HashSet<>();
        visited.add(src);
        while (!q.isEmpty()) {
            int curr = q.poll();
            if (curr == dest) return true;
            List<Integer> nei = map.get(curr);
            if (nei == null) continue;
            for (int p : nei) {
                if (!visited.contains(p)) {
                    q.offer(p);
                    visited.add(p);
                }
            }
        }
        return false;
    }

    Map<Integer, List<Integer>> neighbors = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public boolean pathExists(int n, int[][] edges, int src, int dest) {
        for (int i = 0; i < edges.length; i++) {
            int zero = edges[i][0];
            int first = edges[i][1];
            if (neighbors.containsKey(zero)) {
                List<Integer> li = neighbors.get(zero);
                li.add(first);
                neighbors.put(zero, li);
            } else {
                List<Integer> li = new ArrayList<>();
                li.add(first);
                neighbors.put(zero, li);
            }
            if (neighbors.containsKey(first)) {
                List<Integer> li = neighbors.get(first);
                li.add(zero);
                neighbors.put(first, li);
            } else {
                List<Integer> li = new ArrayList<>();
                li.add(zero);
                neighbors.put(first, li);
            }
        }

        return dfs(src, dest);
    }

    public boolean dfs(int src, int dest) {
        if (src == dest) return true;
        if (neighbors.get(src) == null) return false;
        visited.add(src);
        for (int n : neighbors.get(src)) {
            if (!visited.contains(n)) {
                if (dfs(n, dest)) {
                    return true;
                }
            }
        }
        return false;
    }
}
