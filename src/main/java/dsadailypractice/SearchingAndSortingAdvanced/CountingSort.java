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

    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 5, 3, 3, 2, 1, 4};
        System.out.println(Arrays.toString(unstableCountingSort(arr)));
    }
}
