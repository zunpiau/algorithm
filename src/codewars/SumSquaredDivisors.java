package codewars;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SumSquaredDivisors {

    public static String listSquared(long m, long n) {
        List<long[]> result = new LinkedList<>();
        for (long i = m; i <= n; i++) {
            long sqrt = (long) Math.sqrt(i);
            long sum = 0;
            for (long j = 1; j <= sqrt; j++) {
                if (i % j == 0) {
                    long q = i / j;
                    sum += j * j;
                    if (q != j)
                        sum += q * q;
                }
            }
            if (Math.sqrt(sum) % 1 == 0) {
                result.add(new long[]{i, sum});
            }
        }
        return Arrays.deepToString(result.toArray());
    }

    @Test
    public void test1() {
        assertEquals("[[1, 1], [42, 2500], [246, 84100]]", SumSquaredDivisors.listSquared(1, 250));
    }

    @Test
    public void test2() {
        assertEquals("[[42, 2500], [246, 84100]]", SumSquaredDivisors.listSquared(42, 250));
    }

    @Test
    public void test3() {
        assertEquals("[[287, 84100]]", SumSquaredDivisors.listSquared(250, 500));
    }

}
