package dsadailypractice.DynamicProgramming;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int minProd = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int maxProdCopy = maxProd;
            maxProd = Math.max(nums[i], Math.max(maxProd * nums[i], minProd * nums[i]));
            minProd = Math.min(nums[i], Math.min(maxProdCopy * nums[i], minProd * nums[i]));
            max = Math.max(maxProd, max);
        }
        return max;
    }
}
