package dsadailypractice.GreedyAlgorithm;

import java.util.Arrays;

public class Candy {
    public int candyUsingExtraSpace(int[] arr) {
        int n = arr.length;
        int[] ltr = new int[n];
        Arrays.fill(ltr, 1);
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                ltr[i] = ltr[i - 1] + 1;
            }
        }
        int[] rtl = new int[n];
        Arrays.fill(rtl, 1);
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                rtl[i] = rtl[i + 1] + 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.max(ltr[i], rtl[i]);
        }
        return ans;
    }

    public int candyUsingNoExtraSpace(int[] arr) {
        int n = arr.length;
        int ans = n;
        int i = 1;
        while (i < n) {
            if (arr[i] == arr[i - 1]) {
                i++;
                continue;
            }
            int up = 0;
            while (i < n && arr[i] > arr[i - 1]) {
                up++;
                ans += up;
                i++;
            }
            int down = 0;
            while (i < n && arr[i] < arr[i - 1]) {
                down++;
                ans += down;
                i++;
            }
            ans = ans - Math.min(up, down);
        }
        return ans;
    }
}
