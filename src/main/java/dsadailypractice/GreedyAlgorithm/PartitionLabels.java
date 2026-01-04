package dsadailypractice.GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int[] start = new int[26];
        Arrays.fill(start, -1);
        int[] end = new int[26];
        Arrays.fill(end, -1);
        for (int i = 0; i < s.length(); i++) {
            int charIndex = s.charAt(i) - 'a';
            if (start[charIndex] < 0)
                start[charIndex] = i;
            end[charIndex] = i;
        }
        int partitionStart = 0, partitionEnd = 0;
        for (int i = 0; i < s.length(); i++) {
            int charIndex = s.charAt(i) - 'a';
            if (i > partitionEnd) {
                ans.add(partitionEnd - partitionStart + 1);
                partitionStart = i;
            }
            partitionEnd = Math.max(partitionEnd, end[charIndex]);
        }
        ans.add(partitionEnd - partitionStart + 1);
        return ans;
    }
}
