package dsadailypractice.Stack_Queue;

import java.util.Queue;
import java.util.Stack;

public class ImplementQueueUsingStacks {

    class ApproachOne {

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        public ApproachOne() {
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

    class ApproachTwo {
        Stack<Integer> s1;
        Stack<Integer> s2;

        public ApproachTwo() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void push(int x) {
            s1.push(x);
        }

        public int pop() {
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.pop();
        }

        public int peek() {
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.peek();
        }

        public boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }
    }
}
