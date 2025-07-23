package dsadailypractice.SearchingAndSorting0;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = sortArray(new int[]{-2, 3, -5});
        System.out.println(Arrays.toString(arr));
    }

    public static int[] sortArray(int[] nums) {
        if (nums.length <= 1)
            return nums;
        int mid = nums.length / 2;
        int[] left = sortArray(Arrays.copyOfRange(nums, 0, mid));
        int[] right = sortArray(Arrays.copyOfRange(nums, mid, nums.length));
        return sort(left, right);
    }

    public static int[] sort(int[] arr1, int[] arr2) {
        int len = arr1.length + arr2.length;
        int[] newArr = new int[len];
        int x = 0;
        int y = 0;
        for (int i = 0; i < len; i++) {
            if (x >= arr1.length || (arr2.length > y && arr1[x] >= arr2[y])) {
                newArr[i] = arr2[y];
                y++;
            } else {
                newArr[i] = arr1[x];
                x++;
            }
        }
        return newArr;
    }
}
