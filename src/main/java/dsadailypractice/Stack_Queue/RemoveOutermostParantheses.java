package dsadailypractice.Stack_Queue;

import java.util.Stack;

public class RemoveOutermostParantheses {
    public String removeOuterParanthesesUsingStack(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
                if (stack.size() > 1)
                    sb.append('(');
            } else {
                stack.pop();
                if (stack.size() != 0)
                    sb.append(')');
            }
        }
        return sb.toString();
    }

    public String removeOuterParanthesesUsingCounter(String s) {
        int counter = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                counter++;
                if (counter > 1)
                    sb.append('(');
            } else {
                counter--;
                if (counter > 0)
                    sb.append(')');
            }
        }
        return sb.toString();
    }
}
