package dsadailypractice.TwoPointersAndSlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharactersLength {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            if (map.get(ch) != null && map.get(ch) >= i) {
                i = map.get(ch) + 1;
            }
            map.put(ch, j);
            int ws = j - i + 1;
            max = Math.max(ws, max);
        }
        return max;
    }
}
