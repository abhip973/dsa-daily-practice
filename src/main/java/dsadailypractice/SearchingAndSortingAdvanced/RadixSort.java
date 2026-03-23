package dsadailypractice.SearchingAndSortingAdvanced;

import java.util.Arrays;

public class RadixSort {
    public static void stableCountingSort(int[] arr, int e) {
        int[] count = new int[10];
        for (int x : arr) {
            int digit = (x / e) % 10;
            count[digit]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i - 1];
        }
        int[] sortedArr = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int digit = (arr[i] / e) % 10;
            int num = count[digit];
            sortedArr[num - 1] = arr[i];
            count[digit]--;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sortedArr[i];
        }
    }

    public static int[] radixSort(int[] arr) {
        int max = 0;
        for (int num : arr)
            max = Math.max(num, max);
        for (int e = 1; max / e > 0; e = e * 10) {
            stableCountingSort(arr, e);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println(Arrays.toString(radixSort(arr)));
    }

}
