package dsadailypractice.StringsAdvanced;

public class MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String s) {
        int moves = 0;
        int openCount = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') openCount++;
            else {
                if (openCount > 0) openCount--;
                else moves++;
            }
        }
        return moves + openCount;
    }
}
