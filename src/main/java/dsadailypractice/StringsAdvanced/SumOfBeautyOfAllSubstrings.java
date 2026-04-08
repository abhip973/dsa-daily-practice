package dsadailypractice.StringsAdvanced;

public class SumOfBeautyOfAllSubstrings {
    public int beautySum(String s) {
        int totalSum = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] freq = new int[26];
            for (int j = i; j < s.length(); j++) {
                int max = 0;
                int min = Integer.MAX_VALUE;
                int c = s.charAt(j) - 'a';
                freq[c]++;
                for (int k = 0; k < 26; k++) {
                    if (freq[k] > 0) {
                        max = Math.max(max, freq[k]);
                        min = Math.min(min, freq[k]);
                    }
                }
                totalSum += (max - min);
            }
        }
        return totalSum;
    }
}
