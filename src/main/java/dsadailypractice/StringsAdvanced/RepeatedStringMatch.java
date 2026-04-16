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
}
