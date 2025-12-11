package dsadailypractice.Heap_PriorityQueue;

import java.util.PriorityQueue;

public class KthSmallestElementInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int size = matrix.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        //Add 1st column elements to the Priority Queue
        for (int i = 0; i < size; i++)
            pq.offer(new int[]{matrix[i][0], i, 0});

        //Get kth smallest element in a matrix
        for (int i = 0; i < k - 1; i++) {
            int[] min = pq.poll();
            if (min[2] + 1 < size)
                pq.offer(new int[]{matrix[min[1]][min[2] + 1], min[1], min[2] + 1});
        }
        return pq.peek()[0];
    }
}
