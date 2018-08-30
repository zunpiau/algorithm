package exercise.point_to_offer;

import org.junit.Assert;
import org.junit.Test;

public class Fibonacci {

    @Test
    public void test() {
        Assert.assertEquals(102334155, fibonacci(40));
    }

    public int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        boolean even = n % 2 == 0;
        int k = even ? n / 2 : (n + 1) / 2;
        int fib1 = fibonacci(k);
        int fib0 = fibonacci(k - 1);
        return even ? (fib1 + fib0 * 2) * fib1 : fib1 * fib1 + fib0 * fib0;
    }

}
