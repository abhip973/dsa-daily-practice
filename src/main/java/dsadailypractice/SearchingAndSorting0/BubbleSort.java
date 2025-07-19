package dsadailypractice.SearchingAndSorting0;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {5, 2, 4, 1};
//        int[] nums = {1, 2, 3, 4};
        int[] sortedNums = bubbleSort(nums);
        for (int x : sortedNums) {
            System.out.print(x + " ");
        }
    }

    public static int[] bubbleSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    isSwapped = true;
                }
            }
            if (!isSwapped) break;
        }
        return nums;
    }
}
