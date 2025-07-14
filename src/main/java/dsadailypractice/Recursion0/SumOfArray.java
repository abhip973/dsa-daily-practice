package dsadailypractice.Recursion0;

public class SumOfArray {
    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 3, 2};
        System.out.println(sum(arr, arr.length - 1));
    }

    public static int sum(int[] arr, int n) {
        if (n == 0) return arr[n];
        return arr[n] + sum(arr, n - 1);
    }
}
