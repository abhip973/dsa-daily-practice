package dsadailypractice.Graphs;

import java.util.*;

public class ReconstructItinerary {
    List<String> ans = new ArrayList<>();
    Map<String, List<String>> map = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (int i = 0; i < tickets.size(); i++) {
            String from = tickets.get(i).get(0);
            String to = tickets.get(i).get(1);
            if (!map.containsKey(from)) {
                map.put(from, new ArrayList<>());
            }
            map.get(from).add(to);
        }
        for (List<String> list : map.values()) {
            Collections.sort(list);
        }
        dfs("JFK");
        Collections.reverse(ans);
        return ans;
    }

    public void dfs(String curr) {
        List<String> list = map.get(curr);
        for (int i = 0; list != null && i < list.size(); ) {
            String from = list.removeFirst();
            dfs(from);
        }
        ans.add(curr);
    }
}
