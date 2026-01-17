package dsadailypractice.DynamicProgramming;

public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length < 3) {
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                max = Math.max(nums[i], max);
            }
            return max;
        }
        //We will include either 0th index or last and compare both results

        //Including 0th index
        int p2 = nums[0];
        int p1 = Math.max(p2, nums[1]);
        for (int i = 2; i < nums.length - 1; i++) {
            int temp = p1;
            p1 = Math.max(p2 + nums[i], p1);
            p2 = temp;
        }

        //Including last index
        int k2 = nums[1];
        int k1 = Math.max(k2, nums[2]);
        for (int i = 3; i < nums.length; i++) {
            int temp = k1;
            k1 = Math.max(k2 + nums[i], k1);
            k2 = temp;
        }
        return Math.max(p1, k1);
    }
}
