package dsadailypractice.DynamicProgramming;

public class PalindromicSubstrings {
    public int countSubStrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            ans++;
            if (i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                ans++;
            }
        }
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    ans++;
                }
            }
        }
        return ans;
    }
}
