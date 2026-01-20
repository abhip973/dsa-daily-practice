package dsadailypractice.DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinChange {
    Map<Integer, Integer> dp = new HashMap<>();

    public int coinChangeMemoization(int[] coins, int rem) {
        if (rem == 0) return 0;
        if (rem < 0) return -1;
        if (dp.containsKey(rem)) return dp.get(rem);
        int minCoins = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int ans = coinChangeMemoization(coins, rem - coins[i]);
            if (ans != -1) {
                minCoins = Math.min(minCoins, ans + 1);
            }
        }
        dp.put(rem, minCoins == Integer.MAX_VALUE ? -1 : minCoins);
        return dp.get(rem);
    }

    public int coinChangeTabulation(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int rem = 1; rem <= amount; rem++) {
            for (int coin : coins) {
                if (rem - coin >= 0 && dp[rem - coin] != Integer.MAX_VALUE) {
                    dp[rem] = Math.min(dp[rem], 1 + dp[rem - coin]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
