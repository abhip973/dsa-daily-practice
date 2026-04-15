package dsadailypractice.StringsAdvanced;

public class ReorganizeString {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int maxFreq = 0;
        int maxChar = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > maxFreq) {
                maxFreq = freq[i];
                maxChar = i;
            }
        }
        if (maxFreq > (s.length() + 1) / 2) return "";
        int idx = 0;
        char[] res = new char[s.length()];
        while (freq[maxChar] > 0) {
            res[idx] = (char) ('a' + maxChar);
            idx += 2;
            freq[maxChar]--;
        }
        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0) {
                if (idx >= s.length()) idx = 1;
                res[idx] = (char) ('a' + i);
                freq[i]--;
                idx += 2;
            }
        }
        return new String(res);
    }
}
