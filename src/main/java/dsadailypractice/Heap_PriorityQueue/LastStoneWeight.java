package dsadailypractice.Heap_PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones)
            pq.offer(stone);
        while (pq.size() > 1) {
            int max1 = pq.poll();
            int max2 = pq.poll();
            int res = Math.abs(max1 - max2);
            if (res > 0)
                pq.offer(res);
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}
