package dsadailypractice.SearchingAndSorting0;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1, 0, 3, 5, 9, 12};
        System.out.println(search(nums, 9));
        System.out.println(search(nums, 2));
    }

    public static int search(int[] nums, int target) {
        int leftPos = 0;
        int rightPos = nums.length - 1;
        int middle = 0;
        while (rightPos > leftPos) {
            middle = (leftPos + rightPos) / 2;
            if (target == nums[middle]) {
                return middle;
            } else if (target > nums[middle]) {
                leftPos = middle + 1;
            } else {
                rightPos = middle - 1;
            }
        }
        return -1;
    }
}
