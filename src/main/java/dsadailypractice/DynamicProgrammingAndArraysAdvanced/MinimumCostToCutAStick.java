package dsadailypractice.DynamicProgrammingAndArraysAdvanced;

import java.util.HashMap;
import java.util.Map;

public class MinimumCostToCutAStick {
    Map<String, Integer> map;

    public int minCost(int n, int[] cuts) {
        map = new HashMap<>();
        return dfs(0, n, cuts);
    }

    public int dfs(int start, int end, int[] cuts) {
        if (start >= end) return 0;
        if (map.containsKey(start + "_" + end)) return map.get(start + "_" + end);
        int minCost = Integer.MAX_VALUE;
        for (int c : cuts) {
            if (c > start && c < end) {
                int currCost = (end - start) + dfs(start, c, cuts) + dfs(c, end, cuts);
                minCost = Math.min(minCost, currCost);
            }
        }
        map.put(start + "_" + end, minCost == Integer.MAX_VALUE ? 0 : minCost);
        return minCost == Integer.MAX_VALUE ? 0 : minCost;
    }
}
