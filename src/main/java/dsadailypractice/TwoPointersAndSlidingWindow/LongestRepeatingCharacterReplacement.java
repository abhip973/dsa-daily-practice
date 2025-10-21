package dsadailypractice.TwoPointersAndSlidingWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int i = 0, j = 0, max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (j = 0; j < s.length(); j++) {
            int totalCount = 0, maxCount = 0;
            char ch = s.charAt(j);
            if (map.containsKey(ch)) {
                int count = map.get(ch);
                map.put(ch, ++count);
            } else {
                map.put(ch, 1);
            }
            Set<Map.Entry<Character, Integer>> entries = map.entrySet();
            for (Map.Entry<Character, Integer> entry : entries) {
                int value = entry.getValue();
                maxCount = Math.max(value, maxCount);
                totalCount += value;
            }
            if (totalCount - maxCount <= k) {
                max = Math.max(max, j - i + 1);
            } else {
                int count = map.get(s.charAt(i));
                map.put(s.charAt(i), --count);
                i++;
            }
        }
        return max;
    }
}
