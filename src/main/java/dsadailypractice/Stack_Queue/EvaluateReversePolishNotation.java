package dsadailypractice.Stack_Queue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Map<String, BiFunction<Integer, Integer, Integer>> map = new HashMap<>();
        map.put("+", (a, b) -> a + b);
        map.put("*", (a, b) -> a * b);
        map.put("/", (a, b) -> a / b);
        map.put("-", (a, b) -> a - b);
        for (int i = 0; i < tokens.length; i++) {
            if (map.containsKey(tokens[i])) {
                int b = stack.pop();
                int a = stack.pop();
                int ans = map.get(tokens[i]).apply(a, b);
                stack.push(ans);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
