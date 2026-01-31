package dsadailypractice.DynamicProgramming;

public class CoinChangeII {
    Integer[][] dp;

    public int change(int amount, int[] coins) {
        dp = new Integer[amount + 1][coins.length];
        return combinations(amount, 0, coins);
    }

    public int combinations(int rem, int start, int[] coins) {
        if (rem == 0) return 1;
        if (rem < 0) return 0;
        if (dp[rem][start] != null) return dp[rem][start];
        int ways = 0;
        for (int i = start; i < coins.length; i++) {
            ways += combinations(rem - coins[i], i, coins);
        }
        return dp[rem][start] = ways;
    }
}
