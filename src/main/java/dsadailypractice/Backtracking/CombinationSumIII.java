package dsadailypractice.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), res);
        return res;
    }

    public void backtrack(int start, int target, int k, List<Integer> curr, List<List<Integer>> res) {
        if (curr.size() == k) {
            if (target == 0) res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = start; i <= 9; i++) {
            curr.add(i);
            backtrack(i + 1, target - i, k, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
