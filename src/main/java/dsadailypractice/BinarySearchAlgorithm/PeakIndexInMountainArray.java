package dsadailypractice.BinarySearchAlgorithm;

public class PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        int m = 0;
        while (l < r) {
            m = l + (r - l) / 2;
            if (arr[m + 1] >= arr[m]) {
                l = m + 1;
            } else if (arr[m] > arr[m + 1]) {
                r = m;
            }
        }
        return l;
    }
}
