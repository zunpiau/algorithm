package exercise.point_to_offer;

import org.junit.Assert;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class StackWithMinFunction {

    private Deque<Integer> stack = new LinkedList<>();
    private Deque<Integer> minStack = new LinkedList<>();

    @Test
    public void test() {
        push(1);
        Assert.assertEquals(1, min());
        push(2);
        push(1);

        Assert.assertEquals(1, min());
        pop();
        Assert.assertEquals(1, min());
        push(0);
        Assert.assertEquals(0, min());
    }

    public void push(int node) {
        stack.push(node);
        if (minStack.isEmpty() || node <= minStack.peek())
            minStack.push(node);
    }

    public void pop() {
        int x = stack.pop();
        if (!minStack.isEmpty() && x == minStack.peek())
            minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }

}
