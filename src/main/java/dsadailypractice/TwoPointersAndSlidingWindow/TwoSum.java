package dsadailypractice.TwoPointersAndSlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSumUsingBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public int[] twoSumUsingHashTable(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.get(diff) != null && map.get(diff) != i) {
                return new int[]{i, map.get(diff)};
            }
        }
        return new int[]{-1, -1};
    }
}
