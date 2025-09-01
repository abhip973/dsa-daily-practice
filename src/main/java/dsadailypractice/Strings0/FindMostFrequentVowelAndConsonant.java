package dsadailypractice.Strings0;

import java.util.HashMap;
import java.util.Map;

public class FindMostFrequentVowelAndConsonant {
    public int maxFreqSum(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (map.get(ch) == null) map.put(ch, 1);
            else {
                int count = map.get(ch);
                map.put(ch, ++count);
            }
        }
        int vowelMax = 0;
        int consonantMax = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getKey() == 'a' || entry.getKey() == 'e' || entry.getKey() == 'i' || entry.getKey() == 'o' || entry.getKey() == 'u')
                vowelMax = Math.max(vowelMax, entry.getValue());
            else
                consonantMax = Math.max(consonantMax, entry.getValue());
        }
        return vowelMax + consonantMax;
    }
}
