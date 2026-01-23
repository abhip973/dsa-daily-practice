package dsadailypractice.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {
    Map<String, Integer> dp = new HashMap<>();

    public int ways(String s) {
        int n = s.length();
        if (s.isEmpty()) return 1;
        if (dp.containsKey(s)) return dp.get(s);
        int twoDigit = 0;
        if (n - 2 >= 0)
            twoDigit = Integer.valueOf(s.substring(n - 2));
        int ans = 0;
        if (s.charAt(n - 1) != '0') {
            ans += ways(s.substring(0, n - 1));
        }
        if (twoDigit >= 10 && twoDigit <= 26) {
            ans += ways(s.substring(0, n - 2));
        }
        dp.put(s, ans);
        return ans;
    }
}
