package dsadailypractice.Recursion0;

public class PowerOfTwo {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(16));
    }

    public static boolean isPowerOfTwo(int n) {
        if (n == 1) return true;
        if (n % 2 == 1 || n <= 0) return false;
        return isPowerOfTwo(n / 2);
    }
}
