package dsadailypractice.Stack_Queue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                map.put(nums2[i], -1);
                stack.push(nums2[i]);
            } else if (stack.peek() > nums2[i]) {
                map.put(nums2[i], stack.peek());
                stack.push(nums2[i]);
            } else {
                while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    stack.push(nums2[i]);
                    map.put(nums2[i], -1);
                } else {
                    map.put(nums2[i], stack.peek());
                    stack.push(nums2[i]);
                }
            }
        }
        int[] newArr = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            newArr[i] = map.get(nums1[i]);
        }
        return newArr;
    }
}
