package dsadailypractice.Recursion0;

public class Factorial {
    public static void main(String[] args) {
        int num = 5;
        System.out.println(fact(num));
    }

    public static int fact(int n) {
        if (n == 1) return 1;
        return n * fact(n - 1);
    }
}
