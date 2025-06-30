package dsadailypractice.Arrays0;

public class ReverseString {
    public static void main(String[] args) {
        char[] s = {'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString(s);
    }

    public static void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[s.length - (i + 1)];
            s[s.length - (i + 1)] = s[i];
            s[i] = temp;
        }
        System.out.println(s);
    }
}
