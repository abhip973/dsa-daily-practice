package dsadailypractice.DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int max = 1;
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }
}
