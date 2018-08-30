package leetcode;

import java.util.Stack;

public class _739_DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] wait = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.empty() && temperatures[i] > temperatures[stack.peek()]) {
                int top = stack.pop();
                wait[top] = i - top;
            }
            stack.add(i);
        }
        return wait;
    }
}
