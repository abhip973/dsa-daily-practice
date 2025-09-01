package dsadailypractice.Strings0;

public class BalancedStringSplit {
    public int balancedStringSplit(String s) {
        int counter = 0;
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'R') counter++;
            if (ch == 'L') counter--;
            if (counter == 0) count++;
        }
        return count;
    }
}
