package dsadailypractice.TwoPointersAndSlidingWindow;

public class TrappingRainWater {
    public int trappedWater(int[] height) {
        int n = height.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        int ans = 0;
        maxLeft[0] = height[0];
        maxRight[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
            maxRight[n - i - 1] = Math.max(maxRight[n - i], height[n - i - 1]);
        }
        for (int i = 0; i < n; i++) {
            int sum = Math.min(maxLeft[i], maxRight[i]) - height[i];
            ans += Math.max(sum, 0);
        }
        return ans;
    }
}
