package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class _503_NextGreaterElementII {

    public int[] nextGreaterElements(int[] nums) {
        int[] nextGreater = new int[nums.length];
        Arrays.fill(nextGreater, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < (nums.length * 2); i++) {
            int j = nums[i % nums.length];
            while (!stack.isEmpty() && j > nums[stack.peek()]) {
                nextGreater[stack.pop()] = j;
            }
            if (i < nums.length)
                stack.push(i);
        }
        return nextGreater;
    }

}
