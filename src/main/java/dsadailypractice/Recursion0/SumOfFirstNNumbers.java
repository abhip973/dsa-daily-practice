package dsadailypractice.Recursion0;

public class SumOfFirstNNumbers {

    public static void main(String[] args) {
        int num = 6;
        System.out.println(sum(num));
    }

    public static int sum(int num) {
        if (num == 0) return 0;
        return num + sum(num - 1);
    }
}
