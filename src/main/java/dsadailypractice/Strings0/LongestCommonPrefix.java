package dsadailypractice.Strings0;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int x = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() == x || strs[0].charAt(i) != strs[j].charAt(i)) {
                    return strs[0].substring(0, x);
                }
            }
            x++;
        }
        return strs[0];
    }
}
