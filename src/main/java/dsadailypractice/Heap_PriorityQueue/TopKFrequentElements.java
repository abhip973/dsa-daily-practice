package dsadailypractice.Heap_PriorityQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        // Maintaining a map to store count for each element
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num))
                map.put(num, 1);
            else {
                int count = map.get(num);
                map.put(num, ++count);
            }
        }
        // Sort on the basis of values count using Priority Queue
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
            if (pq.size() > k)
                pq.poll();
        }

        //Creating answer array
        int[] ans = new int[k];
        for (int i = k - 1; i >= 0; i--)
            ans[i] = pq.poll()[0];
        return ans;
    }
}
