package dsadailypractice.SearchingAndSortingAdvanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public static double[] bucketSort(double[] arr) {

        int n = arr.length;
        List<Double>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int index = (int) (arr[i] * n);
            buckets[index].add(arr[i]);
        }
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (double d : buckets[i]) {
                arr[k++] = d;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        double[] arr = {0.78, 0.17, 0.39, 0.26, 0.72};
        System.out.println(Arrays.toString(bucketSort(arr)));
    }
}
