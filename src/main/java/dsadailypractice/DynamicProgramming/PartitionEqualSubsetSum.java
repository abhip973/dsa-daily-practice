package dsadailypractice.DynamicProgramming;

public class PartitionEqualSubsetSum {
    Boolean[][] dp;

    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if (total % 2 != 0) return false;
        dp = new Boolean[(total / 2) + 1][nums.length + 1];
        return subsets(total / 2, 0, nums);
    }

    public boolean subsets(int remSum, int start, int[] nums) {
        if (remSum == 0) return true;
        if (remSum < 0) return false;
        if (dp[remSum][start] != null) return dp[remSum][start];
        for (int i = start; i < nums.length; i++) {
            if (subsets(remSum - nums[i], i + 1, nums)) {
                return dp[remSum][start] = true;
            }
        }
        return dp[remSum][start] = false;
    }
}
