package dsadailypractice.Strings0;

public class ValidPalindrome {
    public boolean isPalindromeUsingExtraSpace(String s) {
        s = s.toLowerCase();
        String filterStr = "";
        String reverse = "";
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                filterStr += s.charAt(i);
                reverse = s.charAt(i) + reverse;
            }
        }
        if (filterStr.equals(reverse)) {
            return true;
        }
        return false;
    }

    public boolean isPalindromeUsingFixedSpace(String s) {
        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        while (j > i) {
            while (!(Character.isLetterOrDigit(s.charAt(i))) && j > i)
                i++;
            while (!(Character.isLetterOrDigit(s.charAt(j))) && j > i)
                j--;
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
