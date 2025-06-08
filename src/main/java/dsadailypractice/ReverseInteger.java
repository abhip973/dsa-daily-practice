package dsadailypractice;

public class ReverseInteger {
    public static void main(String[] args) {
        /*
        Problem Statement: Given a signed 32-bit integer x, return x with its digits reversed.
        If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1]
        , then return 0.
         */
        System.out.println(reverse(1534236469));
        System.out.println(reverse(1221));
        System.out.println(reverse(-121221));
    }

    public static int reverse(int x) {
        double xCopy = x;
        x = Math.abs(x);
        double rev = 0;
        while (x > 0) {
            int rem = x % 10;
            rev = (rev * 10) + rem;
            x = x / 10;
        }
        double limit = Math.pow(2, 31);
        if (rev < -limit || rev > limit) return 0;
        return ((int) xCopy < 0) ? (int) -rev : (int) rev;
    }
}
