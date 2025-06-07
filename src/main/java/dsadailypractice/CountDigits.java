package dsadailypractice;

public class CountDigits {
    public static void main(String[] args) {
        /*Problem Statement: Write a function countDigits(n) that takes an integer n and
        returns how many digits it contains.
        Corner cases to cover:
        1. Number is zero.
        2. Number is negative integer
         */
        System.out.println(countDigits(112));
        System.out.println(countDigits(0));
        System.out.println(countDigits(-112131));
    }

    private static int countDigits(int n) {
        if (n == 0) {
            return 1;
        }
        n = Math.abs(n);
        int count = 0;
        while (n > 0) {
            n = n / 10;
            count++;
        }
        return count;
    }
}
