package dsadailypractice.Graphs;

import java.util.Arrays;

public class MinimumSpanningTreeKruskalAlgorithm {
    static int[] uf;
    static int[] rank;

    public static void MinimumSpanningTreeKruskalAlgorithm(int n) {
        uf = new int[n];
        for (int i = 0; i < n; i++) {
            uf[i] = i;
        }
        rank = new int[n];
    }

    public static int find(int n) {
        if (uf[n] != n) {
            uf[n] = find(uf[n]);
        }
        return uf[n];
    }

    public static boolean union(int x, int y) {
        if (find(x) == find(y)) return false;
        int rootX = find(x);
        int rootY = find(y);
        if (rank[rootX] > rank[rootY]) {
            uf[rootY] = rootX;
        } else if (rank[rootY] > rank[rootX]) {
            uf[rootX] = rootY;
        } else {
            uf[rootY] = rootX;
            rank[rootX]++;
        }
        return true;
    }

    public static int kruskalAlgo(int n, int[][] edges) {
        MinimumSpanningTreeKruskalAlgorithm(n);
        int ans = 0;
        int count = 0;

        //Sort edges on the basis of weight
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);
        for (int i = 0; i < edges.length && count < n - 1; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            if (union(u, v)) {
                ans += w;
                count++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] edges = {
                {0, 1, 4}, {0, 2, 4}, {1, 2, 2},
                {2, 3, 3}, {2, 5, 2}, {2, 4, 4},
                {3, 4, 3}, {5, 4, 3}
        };
        System.out.println(kruskalAlgo(6, edges));


    }
}
