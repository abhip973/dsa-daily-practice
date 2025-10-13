package dsadailypractice.TwoPointersAndSlidingWindow;

public class FirstOccurrenceOfAString {
    public int strStr(String needle, String haystack) {
        int i = 0;
        int ws = needle.length();
        while ((i + ws) <= haystack.length()) {
            int j;
            for (j = 0; j < ws; j++) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
            }
            if (j == ws) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
