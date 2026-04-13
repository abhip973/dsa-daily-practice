package dsadailypractice.StringsAdvanced;

public class CountAndSay {
    public String countAndSay(int n) {
        String ans = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder str = new StringBuilder();
            int count = 1;
            for (int j = 1; j < ans.length(); j++) {
                if (ans.charAt(j) == ans.charAt(j - 1)) {
                    count++;
                } else {
                    str.append(count).append(ans.charAt(j - 1));
                    count = 1;
                }
            }
            str.append(count).append(ans.charAt(ans.length() - 1));
            ans = str.toString();
        }
        return ans;
    }
}
