package dsadailypractice.Arrays0;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        movingZeroes(nums);
    }

    public static void movingZeroes(int[] nums) {
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[x] = nums[i];
                x++;
            }
        }
        for (int i = x; i < nums.length; i++) {
            nums[i] = 0;
        }
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
