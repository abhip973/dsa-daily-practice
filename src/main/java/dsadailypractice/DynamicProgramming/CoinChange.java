package dsadailypractice.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {
    Map<Integer, Integer> dp = new HashMap<>();

    public int coinChange(int[] coins, int rem) {
        if (rem == 0) return 0;
        if (rem < 0) return -1;
        if (dp.containsKey(rem)) return dp.get(rem);
        int minCoins = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int ans = coinChange(coins, rem - coins[i]);
            if (ans != -1) {
                minCoins = Math.min(minCoins, ans + 1);
            }
        }
        dp.put(rem, minCoins == Integer.MAX_VALUE ? -1 : minCoins);
        return dp.get(rem);
    }
}
