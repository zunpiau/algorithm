package leetcode._232_ImplementQueueUsingStacks;

import java.util.Stack;

public class MyQueue {

    private Stack<Integer> stack;

    public MyQueue() {
        stack = new Stack<>();
    }

    public void push(int x) {
        Stack<Integer> temp = new Stack<>();
        while (!stack.empty()) {
            temp.push(stack.pop());
        }
        stack.push(x);
        while (!temp.empty()) {
            stack.push(temp.pop());
        }
    }

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.empty();
    }

}
