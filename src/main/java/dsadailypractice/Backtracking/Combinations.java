package dsadailypractice.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(1, n, k, new ArrayList<>(), result);
        return result;
    }

    public void backtracking(int index, int n, int k, List<Integer> curr, List<List<Integer>> result) {
        if (curr.size() == k) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int i = index; i <= n; i++) {
            curr.add(i);
            backtracking(i + 1, n, k, curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}
