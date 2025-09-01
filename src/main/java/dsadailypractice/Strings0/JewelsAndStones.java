package dsadailypractice.Strings0;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        Set<Character> jewelSet = new HashSet<>();
        for (char jewel : jewels.toCharArray())
            jewelSet.add(jewel);
        for (int i = 0; i < stones.length(); i++) {
            if (jewelSet.contains(stones.charAt(i)))
                count++;
        }
        return count;
    }
}
