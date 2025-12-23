package dsadailypractice.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s);
        backtrack(sb, new ArrayList<>(), res);
        return res;
    }

    public void backtrack(StringBuilder sb, List<String> curr, List<List<String>> res) {
        if (sb.isEmpty())
            res.add(new ArrayList<>(curr));
        for (int i = 1; i <= sb.length(); i++) {
            String currentStr = sb.substring(0, i);
            if (!isPalindrome(currentStr)) continue;
            curr.add(currentStr);
            StringBuilder newStr = new StringBuilder(sb.substring(i));
            backtrack(newStr, curr, res);
            curr.remove(curr.size() - 1);
        }
    }

    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }
}
