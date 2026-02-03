package dsadailypractice.DynamicProgramming;

public class UniquePaths {
    Integer[][] dp;

    public int uniquePathsMemoization(int m, int n) {
        dp = new Integer[m][n];
        return recurse(m - 1, n - 1);
    }

    public int recurse(int m, int n) {
        if (m == 0 && n == 0) return 1;
        if (m < 0 || n < 0) return 0;
        if (dp[m][n] != null) return dp[m][n];
        return dp[m][n] = recurse(m - 1, n) + recurse(m, n - 1);
    }

    public int uniquePathsTabulation(int m, int n) {
        int[][] mem = new int[m][n];
        for (int i = 0; i < m; i++) {
            mem[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            mem[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                mem[i][j] = mem[i - 1][j] + mem[i][j - 1];
            }
        }
        return mem[m - 1][n - 1];
    }
}
