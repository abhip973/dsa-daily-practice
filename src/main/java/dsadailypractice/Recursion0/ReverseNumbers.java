package dsadailypractice.Recursion0;

public class ReverseNumbers {
    public static void main(String[] args) {
        int num = 211;
        print(num);
    }

    public static void print(int num) {
        if (num == 0) return;
        System.out.println(num);
        num--;
        print(num);
    }
}
