package dsadailypractice.Arrays0;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        /*
        There are 2 ways to solve this problem:
        1. Keeping a hashmap to track the occurrence of each number and returning the number with value 1.
        2. Using XOR-^(Exclusive OR) operation according to which:
            a^a = 0
            a^0 = a
            1^0 = 1
            0^0 = 0
         */
        int xor = 0;
        for (int num : nums) {
            xor = xor ^ num;
        }
        return xor;
    }
}
