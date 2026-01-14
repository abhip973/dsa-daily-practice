package dsadailypractice.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {
    Map<Integer, Integer> map = new HashMap<>();

    public int climbStairsRecursion(int n) {
        if (n <= 2) return n;
        int val;
        if (!map.containsKey(n)) {
            val = climbStairsRecursion(n - 1) + climbStairsRecursion(n - 2);
            map.put(n, val);
        }
        return map.get(n);
    }

    public int climbStairsTabulation(int n) {
        int[] dp = new int[n + 1];
        if (n <= 2) return n;
        for (int i = 0; i <= 2; i++) {
            dp[i] = i;
        }
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
