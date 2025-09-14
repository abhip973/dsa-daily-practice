package dsadailypractice.Stack_Queue;

import java.util.Queue;
import java.util.Stack;

public class ImplementQueueUsingStacks {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public ImplementQueueUsingStacks() {
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        int size = s1.size();
        for (int i = 0; i < size - 1; i++) {
            s2.push(s1.pop());
        }
        int x = s1.pop();
        for (int i = 0; i < size - 1; i++) {
            s1.push(s2.pop());
        }
        return x;
    }

    public int peek() {
        int size = s1.size();
        for (int i = 0; i < size - 1; i++) {
            s2.push(s1.pop());
        }
        int x = s1.peek();
        s2.push(s1.pop());
        for (int i = 0; i < size; i++) {
            s1.push(s2.pop());
        }
        return x;
    }

    public boolean empty() {
        return s1.isEmpty();
    }
}
