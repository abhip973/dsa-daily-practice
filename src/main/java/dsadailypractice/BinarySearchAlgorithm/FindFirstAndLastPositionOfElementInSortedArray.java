package dsadailypractice.BinarySearchAlgorithm;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int l1 = 0;
        int r1 = nums.length - 1;
        int m1 = 0;
        while (l1 < r1) {
            m1 = l1 + (r1 - l1) / 2;
            if (nums[m1] < target) {
                l1 = m1 + 1;
            } else if (nums[m1] > target) {
                r1 = m1 - 1;
            } else {
                r1 = m1;
            }
        }
        if (nums[l1] != target) return new int[]{-1, -1};

        int l2 = 0;
        int r2 = nums.length - 1;
        int m2 = 0;
        while (l2 < r2) {
            m2 = l2 + (r2 - l2) / 2 + 1;
            if (nums[m2] < target) {
                l2 = m2 + 1;
            } else if (nums[m2] > target) {
                r2 = m2 - 1;
            } else {
                l2 = m2;
            }
        }
        return new int[]{l1, l2};
    }
}
