package dsadailypractice.SearchingAndSorting0;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 4, 3, 2};
        int[] sortedNums = selectionSort(nums);
        for (int x : sortedNums) {
            System.out.print(x + " ");
        }
    }

    public static int[] selectionSort(int[] nums) {
        int n = nums.length;
        int min = 0;
        for (int i = 0; i < n - 1; i++) {
            min = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = nums[i];
                nums[i] = nums[min];
                nums[min] = temp;
            }
        }
        return nums;
    }
}