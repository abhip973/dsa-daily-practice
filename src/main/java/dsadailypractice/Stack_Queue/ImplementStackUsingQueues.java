package dsadailypractice.Stack_Queue;

import java.util.*;

public class ImplementStackUsingQueues {

    class ImplementStackUsingTwoQueues {
        Queue<Integer> q1;
        Queue<Integer> q2;

        public ImplementStackUsingTwoQueues() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        public void push(int x) {
            q1.offer(x);
        }

        public int pop() {
            while (q1.size() > 1) {
                q2.offer(q1.poll());
            }
            int x = q1.poll();
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
            return x;
        }

        public int top() {
            while (q1.size() > 1) {
                q2.offer(q1.poll());
            }
            int x = q1.peek();
            q2.offer(q1.poll());
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
            return x;
        }

        public boolean empty() {
            return q1.isEmpty();
        }
    }

    class ImplementStackUsingSingleQueue {
        Queue<Integer> q1;

        public ImplementStackUsingSingleQueue() {
            q1 = new LinkedList<>();
        }

        public void push(int x) {
            q1.offer(x);
        }

        public int pop() {
            int size = q1.size();
            for (int i = 0; i < size - 1; i++) {
                q1.offer(q1.poll());
            }
            return q1.poll();
        }

        public int top() {
            int size = q1.size();
            for (int i = 0; i < size - 1; i++) {
                q1.offer(q1.poll());
            }
            int x = q1.peek();
            q1.offer(q1.poll());
            return x;
        }

        public boolean empty() {
            return q1.isEmpty();
        }
    }
}
