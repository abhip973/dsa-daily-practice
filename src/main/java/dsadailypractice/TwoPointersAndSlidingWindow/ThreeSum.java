package dsadailypractice.TwoPointersAndSlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        //Create a list to store the solution
        List<List<Integer>> list = new ArrayList<>();

        //Sort the list
        Arrays.sort(nums);

        //Iterate over the array and call Two Sum method for each
        for (int i = 0; i < nums.length; i++) {
            //Skip checking if nums[i] == nums[i-1]
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            twoSum(i, nums, list);
        }
        return list;
    }

    public static void twoSum(int x, int[] nums, List<List<Integer>> list) {
        //Our starting point will be from x+1
        int i = x + 1;
        int j = nums.length - 1;

        while (i < j) {
            int sum = nums[x] + nums[i] + nums[j];
            if (sum > 0) {
                j--;
            } else if (sum < 0) {
                i++;
            } else {
                list.add(Arrays.asList(nums[x], nums[i], nums[j]));
                i++;
                j--;

                //Skip checking if after moving i & j pointers have same value
                while (i < j && nums[i] == nums[i - 1]) i++;
                while (i < j && nums[j] == nums[j + 1]) j--;
            }
        }
    }
}
