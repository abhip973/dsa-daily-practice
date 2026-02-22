package dsadailypractice.Graphs;

import java.util.Arrays;

public class AllPairsShortestPath {
    public static int[][] floydWarshallAlgorithm(int[][] edges, int nodes) {
        int[][] res = new int[nodes][nodes];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                if (i == j) {
                    res[i][j] = 0;
                } else {
                    res[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            res[u][v] = w;
        }

        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                for (int k = 0; k < nodes; k++) {
                    if (!(res[j][i] == Integer.MAX_VALUE || res[i][k] == Integer.MAX_VALUE)) {
                        res[j][k] = Math.min(res[j][k], res[j][i] + res[i][k]);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{{0, 1, 2},
                {1, 0, 7},
                {1, 2, 3},
                {2, 1, 8},
                {2, 3, 2},
                {3, 0, 1},
                {3, 1, 5}};
        System.out.println(Arrays.deepToString(floydWarshallAlgorithm(edges, 4)));
    }
}
