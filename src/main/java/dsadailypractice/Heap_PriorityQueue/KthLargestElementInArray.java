package dsadailypractice.Heap_PriorityQueue;

import java.util.PriorityQueue;

public class KthLargestElementInArray {
    public int findKthLargestElement(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : nums) {
            pq.add(n);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        return pq.peek();
    }
}
