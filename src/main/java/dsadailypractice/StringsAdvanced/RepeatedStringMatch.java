package dsadailypractice.StringsAdvanced;

public class RepeatedStringMatch {
    public int repeatedStringMatch(String a, String b) {
        String text = a;
        int count = 1;
        while (text.length() < b.length()) {
            text += a;
            count++;
        }
        if (text.contains(b)) return count;
        text += a;
        count++;
        if (text.contains(b)) return count;
        return -1;
    }

    public int repeatedStringMatchRabinKarp(String a, String b) {
        String text = a;
        int count = 1;
        while (text.length() < b.length()) {
            text += a;
            count++;
        }
        if (rabinKarp(text, b)) {
            return count;
        }
        text += a;
        count++;
        if (rabinKarp(text, b)) {
            return count;
        }
        return -1;
    }

    public boolean rabinKarp(String text, String pattern) {
        int base = 26;
        int mod = (int) 1e9 + 7;
        int n = text.length();
        int m = pattern.length();
        long patternHash = 0;
        long windowHash = 0;
        for (int i = 0; i < m; i++) {
            patternHash = (patternHash * base + pattern.charAt(i)) % mod;
            windowHash = (windowHash * base + text.charAt(i)) % mod;
        }
        long power = 1;
        for (int i = 0; i < m - 1; i++) {
            power = (power * base) % mod;
        }
        for (int i = 0; i <= n - m; i++) {
            if (windowHash == patternHash) {
                if (text.substring(i, i + m).equals(pattern)) {
                    return true;
                }
            }
            if (i < n - m) {
                windowHash = (windowHash - (power * text.charAt(i))) % mod;
                if (windowHash < 0)
                    windowHash += mod;
                windowHash = (windowHash * base + text.charAt(i + m)) % mod;
            }
        }
        return false;
    }

}
