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
        System.out.println(bfsUsingKahnAlgorithm(n, graph));
    }

    public static List<Integer> bfsUsingKahnAlgorithm(int n, int[][] adj) {
        int[] inDegree = new int[n];
        List<Integer> bfsAns = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < adj[i].length; j++) {
                inDegree[adj[i][j]]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int curr = q.poll();
            bfsAns.add(curr);
            for (int i = 0; i < adj[curr].length; i++) {
                inDegree[adj[curr][i]]--;
                if (inDegree[adj[curr][i]] == 0) {
                    q.offer(adj[curr][i]);
                }
            }
        }
        return bfsAns;
    }
}

