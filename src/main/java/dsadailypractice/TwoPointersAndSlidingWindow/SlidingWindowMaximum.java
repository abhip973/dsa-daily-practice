package dsadailypractice.TwoPointersAndSlidingWindow;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        int i = 0, j = 0;
        Deque<Integer> dq = new LinkedList<>();
        while (j < nums.length) {
            while (!dq.isEmpty() && dq.peekLast() < nums[j]) {
                dq.pollLast();
            }
            dq.offer(nums[j]);
            if (j >= k - 1) {
                ans[i] = dq.peekFirst();
                if (dq.peekFirst() == nums[i]) {
                    dq.pollFirst();
                }
                i++;
            }
            j++;
        }
        return ans;
    }
}
