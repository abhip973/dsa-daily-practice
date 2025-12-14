package dsadailypractice.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = new ArrayList<>();
        backtracking(0, nums, new ArrayList<>(), result);
        System.out.println(result);
    }

    public static void backtracking(int index, int[] nums, List<Integer> curr, List<List<Integer>> result) {
        result.add(new ArrayList<>(curr));
        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            backtracking(i + 1, nums, curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}
