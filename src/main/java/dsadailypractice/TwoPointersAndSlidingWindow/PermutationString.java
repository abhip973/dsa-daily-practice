package dsadailypractice.TwoPointersAndSlidingWindow;

import java.util.Arrays;

public class PermutationString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        int i = 0, j = s1.length() - 1;
        for (int k = 0; k < s1.length(); k++) {
            ++arr1[s1.charAt(k) - 'a'];
            ++arr2[s2.charAt(k) - 'a'];
        }
        while (j < s2.length()) {
            if (Arrays.equals(arr1, arr2)) return true;
            else {
                --arr2[s2.charAt(i) - 'a'];
                i++;
                j++;
                if (j < s2.length())
                    ++arr2[s2.charAt(j) - 'a'];
            }
        }
        return false;
    }
}
