package dsadailypractice.BinarySearchAlgorithm;

public class SingleNonDuplicate {
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int m = 0;
        while (l < r) {
            m = l + (r - l) / 2;
            if (m > 0 && nums[m] == nums[m - 1]) {
                int left = m - 1 - l;
                if (left % 2 == 0) {
                    l = m + 1;
                } else {
                    r = m - 2;
                }
            } else if (m < nums.length - 1 && nums[m] == nums[m + 1]) {
                int left = m - l;
                if (left % 2 == 0) {
                    l = m + 2;
                } else {
                    r = m - 1;
                }
            } else {
                return nums[m];
            }
        }
        return nums[l];
    }
}
