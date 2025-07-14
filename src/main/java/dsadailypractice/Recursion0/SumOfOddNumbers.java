package dsadailypractice.Recursion0;

public class SumOfOddNumbers {
    public static void main(String[] args) {
        int[] arr = {5, 7, 2, 4, 1, 3, 0};
        System.out.println(sumOfOddNumbers(arr, arr.length - 1));
    }

    public static int sumOfOddNumbers(int[] arr, int n) {
        if (n == 0) {
            return arr[n] % 2 == 1 ? arr[n] : 0;
        }
        return arr[n] % 2 == 1 ? arr[n] + sumOfOddNumbers(arr, n - 1) : sumOfOddNumbers(arr, n - 1);
    }
}
