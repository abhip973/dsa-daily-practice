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

    public int maxProductII(int[] nums) {
        int n = nums.length;
        int ltr = 1;
        int rtl = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            ltr = ltr * nums[i];
            rtl = rtl * nums[n - i - 1];
            max = Math.max(ltr, Math.max(rtl, max));
            if (ltr == 0) {
                ltr = 1;
            }
            if (rtl == 0)
                rtl = 1;
        }
        return max;
    }
}
