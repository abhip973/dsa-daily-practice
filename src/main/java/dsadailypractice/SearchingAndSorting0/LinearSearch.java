package dsadailypractice.SearchingAndSorting0;

public class LinearSearch {
    public static void main(String[] args) {
        int[] nums = {4, 2, 1, 5, 6, 0};
        int x = 6;
        System.out.println(findPosition(nums, x));
    }

    public static int findPosition(int[] nums, int x) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) return i;
        }
        return -1;
    }
}
