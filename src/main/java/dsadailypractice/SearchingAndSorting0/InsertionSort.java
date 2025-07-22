package dsadailypractice.SearchingAndSorting0;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 2, 1, 6, 3};
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int prev = i - 1;
            while (prev >= 0 && arr[prev] > current) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            arr[prev + 1] = current;
        }
        System.out.println(Arrays.toString(arr));
    }
}
