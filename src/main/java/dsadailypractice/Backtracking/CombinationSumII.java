package dsadailypractice.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(0, nums, target, new ArrayList<>(), res);
        return res;
    }

    public void backtracking(int start, int[] nums, int target, List<Integer> curr, List<List<Integer>> res) {
        if (target == 0) res.add(new ArrayList<>(curr));
        if (target <= 0) return;
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            curr.add(nums[i]);
            backtracking(i + 1, nums, target - nums[i], curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
