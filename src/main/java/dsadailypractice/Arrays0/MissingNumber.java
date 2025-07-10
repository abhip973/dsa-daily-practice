package dsadailypractice.Arrays0;

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
        int totalSum = (nums.length * (nums.length + 1)) / 2;
        int arraySum = 0;
        for (int i = 0; i < nums.length; i++) {
            arraySum += nums[i];
        }
        return totalSum - arraySum;
    }
}
