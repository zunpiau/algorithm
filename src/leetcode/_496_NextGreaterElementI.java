package leetcode;

import java.util.HashMap;
import java.util.Stack;

public class _496_NextGreaterElementI {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nextGreater = new int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<>(nums2.length);
        Stack<Integer> stack = new Stack<>();
        for (int i : nums2) {
            while (!stack.isEmpty() && stack.peek() < i) {
                map.put(stack.pop(), i);
            }
            stack.add(i);
        }
        for (int i = 0; i < nums1.length; i++) {
            nextGreater[i] = map.getOrDefault(nums1[i], -1);
        }
        return nextGreater;
    }

}
