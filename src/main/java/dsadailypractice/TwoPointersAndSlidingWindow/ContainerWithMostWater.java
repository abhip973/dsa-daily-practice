package dsadailypractice.TwoPointersAndSlidingWindow;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, maxWater = 0;
        while (i < j) {
            int area = Math.min(height[i], height[j]) * (j - i);
            maxWater = Math.max(area, maxWater);
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return maxWater;
    }
}