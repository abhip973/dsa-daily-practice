package dsadailypractice.BinarySearchAlgorithm;

public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int m = 0;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (nums[m] == target) return m;
            else if (nums[m] >= nums[l]) {
                if (target >= nums[l] && target < nums[m]) r = m - 1;
                else l = m + 1;
            } else if (nums[m] <= nums[r]) {
                if (target <= nums[r] && target > nums[m]) l = m + 1;
                else r = m - 1;
            }
        }
        return -1;
    }
}
