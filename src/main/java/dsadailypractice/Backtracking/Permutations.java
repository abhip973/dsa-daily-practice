package dsadailypractice.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(nums, new ArrayList<>(), res);
        return res;
    }

    public void backtracking(int[] nums, List<Integer> curr, List<List<Integer>> res) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!curr.contains(nums[i])) {
                curr.add(nums[i]);
                backtracking(nums, curr, res);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
