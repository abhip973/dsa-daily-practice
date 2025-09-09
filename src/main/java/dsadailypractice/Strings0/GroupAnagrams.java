package dsadailypractice.Strings0;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagramsUsingSortedKey(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            if (!map.containsKey(sortedStr)) {
                List<String> li = new ArrayList<>();
                li.add(strs[i]);
                map.put(sortedStr, li);
            } else {
                List<String> li = map.get(sortedStr);
                li.add(strs[i]);
                map.put(sortedStr, li);
            }
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagramsUsingHashedKey(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            int[] freq = new int[128];
            for (int j = 0; j < strs[i].length(); j++) {
                int pos = strs[i].charAt(j);
                freq[pos]++;
            }
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < 128; k++) {
                sb.append('#').append(freq[k]);
            }
            String hashedKey = sb.toString();

            if (!map.containsKey(hashedKey)) {
                List<String> li = new ArrayList<>();
                li.add(strs[i]);
                map.put(hashedKey, li);
            } else {
                List<String> li = map.get(hashedKey);
                li.add(strs[i]);
                map.put(hashedKey, li);
            }
        }
        return new ArrayList<>(map.values());
    }
}
