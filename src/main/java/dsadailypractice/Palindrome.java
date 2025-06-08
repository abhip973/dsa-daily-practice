package dsadailypractice;

public class Palindrome {
    /*
    Problem Statement: Given an integer n, return true if n is a palindrome, and false otherwise.
     */
    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
    }

    public static boolean isPalindrome(int n) {
        int nCopy = n;
        if (n < 0) {
            return false;
        }
        int rev = 0;
        int rem = 0;
        while (n > 0) {
            rem = n % 10;
            rev = (rev * 10) + rem;
            n = n / 10;
        }
        return nCopy == rev;
    }
}
