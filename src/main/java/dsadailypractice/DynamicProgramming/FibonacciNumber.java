package dsadailypractice.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class FibonacciNumber {
    Map<Integer, Integer> dp = new HashMap<>();

    public int fib1(int n) {
        if (n < 2) return n;
        int val;
        if (!dp.containsKey(n)) {
            val = fib1(n - 1) + fib1(n - 2);
            dp.put(n, val);
        }
        return dp.get(n);
    }

    public int fib2(int n) {
        int[] store = new int[n + 1];
        if (n < 2) {
            return n;
        }
        store[0] = 0;
        store[1] = 1;
        for (int i = 2; i <= n; i++) {
            store[i] = store[i - 1] + store[i - 2];
        }
        return store[n];
    }
}
