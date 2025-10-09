package dsadailypractice.BinarySearchAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class FindClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0;
        int r = arr.length - k;
        while (l < r) {
            int m = l + (r - l) / 2;
            if ((x - arr[m]) <= (arr[m + k] - x)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        List<Integer> li = new ArrayList<>();
        for (int i = l; i < k + l; i++) {
            li.add(arr[i]);
        }
        return li;
    }
}
