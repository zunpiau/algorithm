package misc;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class Fibonacci {

    public static long recursive(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return recursive(n - 1) + recursive(n - 2);
    }

    public static BigInteger recurrence(int n) {
        BigInteger t, fib0 = BigInteger.ZERO, fib1 = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            t = fib1;
            fib1 = fib1.add(fib0);
            fib0 = t;
        }
        return fib1;
    }

    public static BigInteger fastRecursive(int n) {
        if (n == 0) return BigInteger.ZERO;
        if (n == 1) return BigInteger.ONE;
        boolean even = n % 2 == 0;
        int k = even ? n / 2 : (n + 1) / 2;
        BigInteger fib1 = fastRecursive(k);
        BigInteger fib0 = fastRecursive(k - 1);
        return even ? fib1.add(fib0.add(fib0)).multiply(fib1) : fib1.pow(2).add(fib0.pow(2));
    }

    @Test
    public void testRecursive() {
        Assert.assertEquals(102334155, Fibonacci.recursive(40));
    }

    @Test
    public void testFastRecursive() {
        Assert.assertEquals(new BigInteger("222232244629420445529739893461909967206666939096499764990979600"), Fibonacci.fastRecursive(300));
    }

    @Test
    public void testRecurrence() {
        Assert.assertEquals(new BigInteger("222232244629420445529739893461909967206666939096499764990979600"), Fibonacci.recurrence(300));
    }

}
