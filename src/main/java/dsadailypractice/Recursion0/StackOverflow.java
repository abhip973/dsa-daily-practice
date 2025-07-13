package dsadailypractice.Recursion0;

public class StackOverflow {
    public static void main(String[] args) {
        recursion(7);
    }

    public static void recursion(int num) {
        System.out.println(num);
        num--;
        recursion(num);
    }
}
