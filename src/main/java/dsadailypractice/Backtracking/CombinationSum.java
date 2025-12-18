package dsadailypractice.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(0, nums, target, new ArrayList<>(), res);
        return res;
    }

    public void backtracking(int start, int[] nums, int target, List<Integer> curr, List<List<Integer>> res) {
        if (target == 0) res.add(new ArrayList<>(curr));
        if (target <= 0) return;
        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            backtracking(i, nums, target - nums[i], curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
