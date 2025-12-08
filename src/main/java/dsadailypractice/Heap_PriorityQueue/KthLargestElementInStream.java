package dsadailypractice.Heap_PriorityQueue;

import java.util.PriorityQueue;

public class KthLargestElementInStream {
    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargestElementInStream(int[] nums, int k) {
        pq = new PriorityQueue<>();
        this.k = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}
