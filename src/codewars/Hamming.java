package codewars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Hamming {

    public static long hamming(int n) {
        long[] hammingNumbers = new long[n];
        long[] x = {2, 3, 5};
        int[] count = {0, 0, 0};
        int[] multiFactor = {2, 3, 5};
        hammingNumbers[0] = 1;
        for (int l = 1; l < n; l++) {
            hammingNumbers[l] = Math.min(x[0], Math.min(x[1], x[2]));
            for (int i = 0; i < 3; i++) {
                if (hammingNumbers[l] == x[i])
                    x[i] = multiFactor[i] * hammingNumbers[++count[i]];
            }
        }
        return hammingNumbers[hammingNumbers.length - 1];
    }

    @Test
    public void Test1() {
        assertEquals("hamming(1) should be 1", 1, codewars.Hamming.hamming(1));
        assertEquals("hamming(2) should be 2", 2, codewars.Hamming.hamming(2));
        assertEquals("hamming(19) should be 32", 32, codewars.Hamming.hamming(19));
        assertEquals("hamming(1692) should be 2147483648", 2147483648L, codewars.Hamming.hamming(1692));
    }

}
