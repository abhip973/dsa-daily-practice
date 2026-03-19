package dsadailypractice.SearchingAndSortingAdvanced;

import java.util.Arrays;

public class CountingSort {
    public static int[] unstableCountingSort(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int[] range = new int[max + 1];
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            range[arr[i]]++;
        }
        System.out.println(Arrays.toString(range));
        int p = 0;
        for (int i = 0; i <= max; i++) {
            while (range[i] > 0) {
                res[p] = i;
                p++;
                range[i]--;
            }
        }
        return res;
    }

    public static int[] stableCountingSort(int[] arr) {
        int n = arr.length;
        int max = 0;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
        }
        int[] prefixSum = new int[max + 1];
        int[] count = new int[max + 1];
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }
        prefixSum[0] = count[0];
        for (int i = 1; i <= max; i++) {
            prefixSum[i] = prefixSum[i - 1] + count[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            int num = arr[i];
            int pos = prefixSum[num];
            res[pos - 1] = num;
            prefixSum[num]--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 5, 3, 3, 2, 1, 4};
        int[] arr2 = new int[]{2, 5, 1};
        System.out.println(Arrays.toString(unstableCountingSort(arr)));
        System.out.println(Arrays.toString(stableCountingSort(arr2)));
    }
}
