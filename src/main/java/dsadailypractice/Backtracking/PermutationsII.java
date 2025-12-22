package dsadailypractice.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    public List<List<Integer>> uniquePermute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, new ArrayList<>(), res);
        return res;
    }

    public void backtrack(int[] nums, List<Integer> curr, List<List<Integer>> res) {
        if (nums.length == 0)
            res.add(new ArrayList<>(curr));
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            curr.add(nums[i]);
            int[] part1 = Arrays.copyOfRange(nums, 0, i);
            int[] part2 = Arrays.copyOfRange(nums, i + 1, nums.length);
            int[] resultArr = new int[nums.length - 1];
            System.arraycopy(part1, 0, resultArr, 0, part1.length);
            System.arraycopy(part2, 0, resultArr, part1.length, part2.length);
            backtrack(resultArr, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
