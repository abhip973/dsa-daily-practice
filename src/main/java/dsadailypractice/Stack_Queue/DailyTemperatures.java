package dsadailypractice.Stack_Queue;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temp.length];
        stack.push(temp.length - 1);
        res[temp.length - 1] = 0;
        for (int i = temp.length - 2; i >= 0; i--) {
            if (temp[stack.peek()] > temp[i]) {
                res[i] = 1;
                stack.push(i);
            } else {
                while (!stack.isEmpty() && temp[i] >= temp[stack.peek()]) {
                    stack.pop();
                }
                res[i] = stack.isEmpty() ? 0 : (stack.peek() - i);
                stack.push(i);
            }
        }
        return res;
    }
}
