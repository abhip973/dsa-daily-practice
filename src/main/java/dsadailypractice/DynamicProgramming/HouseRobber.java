package dsadailypractice.DynamicProgramming;

public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int p2 = nums[0];
        int p1 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            int temp = p1;
            p1 = Math.max(p1, p2 + nums[i]);
            p2 = temp;
        }
        return p1;
    }
}
