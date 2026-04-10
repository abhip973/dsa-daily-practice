package dsadailypractice.StringsAdvanced;

public class DecodeString {
    int i = 0;

    public String decodeString(String s) {
        return recurse(s);
    }

    public String recurse(String s) {
        int number = 0;
        String res = "";
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
                i++;
            } else if (ch == '[') {
                i++;
                String str = recurse(s);
                res = res + str.repeat(number);
                number = 0;
            } else if (ch == ']') {
                i++;
                return res;
            } else {
                res = res + ch;
                i++;
            }
        }
        return res;
    }
}
