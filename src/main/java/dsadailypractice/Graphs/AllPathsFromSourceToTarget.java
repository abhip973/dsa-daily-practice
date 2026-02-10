package dsadailypractice.Graphs;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graphs) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        li.add(0);
        int target = graphs.length - 1;
        dfs(0, target, li, ans, graphs);
        return ans;
    }

    public void dfs(int curr, int end, List<Integer> li, List<List<Integer>> ans, int[][] graph) {
        if (curr == end) {
            ans.add(new ArrayList<>(li));
        }
        for (int i = 0; i < graph[curr].length; i++) {
            li.add(graph[curr][i]);
            dfs(graph[curr][i], end, li, ans, graph);
            li.remove(li.size() - 1);
        }
    }
}
