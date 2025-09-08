package dsadailypractice.Strings0;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (t.length() != s.length())
            return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.get(ch) == null)
                map.put(ch, 1);
            else {
                int count = map.get(ch);
                map.put(ch, ++count);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (map.get(ch) == null || map.get(ch) <= 0)
                return false;
            else {
                int count = map.get(ch);
                map.put(ch, --count);
            }
        }
        return true;
    }
}
