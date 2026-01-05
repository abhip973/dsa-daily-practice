package dsadailypractice.GreedyAlgorithm;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] arr) {
        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));
        int removed = 0;
        int k = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (k > arr[i][0]) {
                removed++;
            } else {
                k = arr[i][1];
            }
        }
        return removed;
    }
}
