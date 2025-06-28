package dsadailypractice.Arrays0;

public class RemoveDuplicatesFromSortedArray {

    //Leetcode link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(arr));
    }

    public static int removeDuplicates(int[] nums) {
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[x]) {
                x++;
                nums[x] = nums[i];
            }
        }
        return ++x;
    }
}
