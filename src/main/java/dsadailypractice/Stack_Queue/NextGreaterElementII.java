package dsadailypractice.Stack_Queue;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    public int[] nextGreaterElementsUsingDoubleArray(int[] nums) {
        int len = 2 * nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[len];
        int[] newArr = new int[len];
        System.arraycopy(nums, 0, newArr, 0, nums.length);
        System.arraycopy(nums, 0, newArr, nums.length, nums.length);
        res[len - 1] = -1;
        stack.push(newArr[len - 1]);
        for (int i = len - 2; i >= 0; i--) {
            if (stack.peek() > newArr[i]) {
                res[i] = stack.peek();
                stack.push(newArr[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() <= newArr[i]) {
                    stack.pop();
                }
                res[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(newArr[i]);
            }
        }
        return Arrays.copyOfRange(res, 0, nums.length);
    }

    public int[] nextGreaterElementsUsingDoubleIteration(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        res[n - 1] = -1;
        stack.push(nums[n - 1]);
        for (int i = (2 * n) - 2; i >= 0; i--) {
            if (stack.peek() > nums[i % n]) {
                res[i % n] = stack.peek();
                stack.push(nums[i % n]);
            } else {
                while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                    stack.pop();
                }
                res[i % n] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(nums[i % n]);
            }
        }
        return res;
    }
}
