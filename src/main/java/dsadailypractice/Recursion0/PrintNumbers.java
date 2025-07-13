package dsadailypractice.Recursion0;

public class PrintNumbers {
    public static void main(String[] args) {
        int num = 11;
        int i = 0;
        printNumbers(num, i);
    }

    public static void printNumbers(int num, int i) {
        if (i > num) return;
        System.out.println(++i);
        printNumbers(num, i);
    }
}
