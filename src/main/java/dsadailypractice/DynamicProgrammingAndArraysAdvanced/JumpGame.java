package dsadailypractice.DynamicProgrammingAndArraysAdvanced;

public class JumpGame {
    public boolean canJump(int[] nums) {
        Boolean[] map = new Boolean[nums.length];
        return dfs(0, nums, map);
    }

    public static boolean dfs(int start, int[] nums, Boolean[] map) {
        if (start == nums.length - 1) return true;
        if (map[start] != null) return map[start];
        boolean ans = false;
        for (int i = 1; i <= nums[start]; i++) {
            ans = ans || dfs(start + i, nums, map);
        }
        map[start] = ans;
        return ans;
    }
}
