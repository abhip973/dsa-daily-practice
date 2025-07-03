package dsadailypractice.Arrays0;

import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        mergeArrays(nums1, nums2, 3, 3);
    }

    public static void mergeArrays(int[] nums1, int[] nums2, int m, int n) {
        //Approach-I: Using additional array
        /*
        int p1 = 0;
        int p2 = 0;
        int[] nums1Copy = Arrays.copyOf(nums1, m);
        for (int i = 0; i < m + n; i++) {
            if (n == 0) break;
            if (p2 >= n || (p1 < m && nums1Copy[p1] <= nums2[p2])) {
                nums1[i] = nums1Copy[p1];
                p1++;
            } else {
                nums1[i] = nums2[p2];
                p2++;
            }
        }
        for (int nums : nums1) {
            System.out.print(nums);
        }

        */

        //Approach-II: Using original array
        int p1 = m - 1;
        int p2 = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (p1 < 0 || (p2 >= 0 && nums1[p1] <= nums2[p2])) {
                nums1[i] = nums2[p2];
                p2--;
            } else {
                nums1[i] = nums1[p1];
                p1--;
            }
        }
        for (int nums : nums1) {
            System.out.print(nums);
        }

    }
}

