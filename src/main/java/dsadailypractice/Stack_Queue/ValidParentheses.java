package dsadailypractice.Stack_Queue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) return false;
                else if (s.charAt(i) != map.get(stack.pop())) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
