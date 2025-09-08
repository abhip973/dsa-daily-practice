package dsadailypractice.Strings0;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() == 1) return true;
        Map<Character, Character> mapStoT = new HashMap<>();
        Map<Character, Character> mapTtoS = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char chS = s.charAt(i);
            char chT = t.charAt(i);

            if (!mapStoT.containsKey(chS) && !mapTtoS.containsKey(chT)) {
                mapStoT.put(chS, chT);
                mapTtoS.put(chT, chS);
            } else if (mapStoT.containsKey(chS) && mapStoT.get(chS) != chT) return false;
            else if (mapTtoS.containsKey(chT) && mapTtoS.get(chT) != chS) return false;
        }
        return true;
    }
}
