package dsadailypractice.SearchingAndSortingAdvanced;

import java.util.Arrays;

public class QuickSort {
    public static int findPivotIndex(int[] arr, int startIndex, int endIndex) {
        int pos = startIndex - 1;
        int val = arr[endIndex];
        for (int i = startIndex; i < endIndex; i++) {
            if (arr[i] < val) {
                pos++;
                int temp = arr[pos];
                arr[pos] = arr[i];
                arr[i] = temp;
            }
        }
        int temp = arr[pos + 1];
        arr[pos + 1] = val;
        arr[endIndex] = temp;
        return pos + 1;
    }

    public static int[] quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int pivot = findPivotIndex(arr, startIndex, endIndex);
            quickSort(arr, startIndex, pivot - 1);
            quickSort(arr, pivot + 1, endIndex);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8, 3, 1, 7, 0, 10, 2};
        System.out.println(Arrays.toString(quickSort(arr, 0, 6)));
    }
}
