package dsadailypractice.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class MinCostClimbingStairs {
    Map<Integer, Integer> dp = new HashMap<>();

    public int minCostClimbingStairsMemoization(int[] cost) {
        return recurse(cost.length, cost);
    }

    public int recurse(int n, int[] cost) {
        if (n < 2) return 0;
        if (!dp.containsKey(n)) {
            int val = Math.min(recurse(n - 1, cost) + cost[n - 1], recurse(n - 2, cost) + cost[n - 2]);
            dp.put(n, val);
        }
        return dp.get(n);
    }

    public int minCostClimbingStairsTabulation(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }
}
