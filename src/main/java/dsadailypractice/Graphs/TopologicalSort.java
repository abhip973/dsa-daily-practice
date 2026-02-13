package dsadailypractice.Graphs;

import java.util.*;

public class TopologicalSort {
    static Set<Integer> visited = new HashSet<>();
    static List<Integer> ans = new ArrayList<>();

    public static List<Integer> topologicalSort(int n, int[][] adj) {
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i))
                dfs(i, adj);
        }
        Collections.reverse(ans);
        return ans;
    }

    public static void dfs(int curr, int[][] adj) {
        visited.add(curr);
        for (int i = 0; i < adj[curr].length; i++) {
            if (!visited.contains(adj[curr][i]))
                dfs(adj[curr][i], adj);
        }
        ans.add(curr);
    }

    public static void main(String[] args) {
        int[][] graph = {
                {},
                {},
                {3},
                {1},
                {0, 1},
                {0, 2}
        };
        int n = 6;

        System.out.println(topologicalSort(n, graph));
    }
}

