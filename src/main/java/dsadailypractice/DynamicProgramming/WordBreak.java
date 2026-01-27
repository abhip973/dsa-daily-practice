package dsadailypractice.DynamicProgramming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {
    Map<String, Boolean> dp = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.isEmpty()) return true;
        if (dp.containsKey(s)) return dp.get(s);
        int n = s.length();
        boolean ans = false;
        for (int i = 0; i < n; i++) {
            if (wordDict.contains(s.substring(0, i + 1))) {
                ans = ans || wordBreak(s.substring(i + 1), wordDict);
            }
        }
        dp.put(s, ans);
        return ans;
    }
}
