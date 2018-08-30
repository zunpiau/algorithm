package exercise.dsa;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MaxKProduct {

    public static int maxKProduct(int n, int k) {
        int length = (int) Math.log10(n) + 1;
        int[] num = new int[length];
        for (int i = length - 1; i >= 0; i--, n /= 10) {
            num[i] = n % 10;
        }
        int[][] mkp = new int[length - 1][k - 1];
        for (int i = 0; i < length - 1; i++) {
            mkp[i][0] = getNumber(num, 0, i + 1);
        }
        for (int i = 1; i < length - 1; i++) {
            for (int j = 1; j <= i && j < k - 1; j++) {
                mkp[i][j] = getMax(mkp, num, i, j - 1);
            }
        }
        System.out.println(Arrays.deepToString(mkp));
        return getMax(mkp, num, length - 1, k - 2);
    }

    private static int getMax(int[][] mkp, int[] num, int endRow, int col) {
        int max = Integer.MIN_VALUE;
        for (int l = 0; l < endRow; l++) {
            int m = mkp[l][col];
            int n = getNumber(num, l + 1, endRow + 1);
            max = Math.max(max, n * m);
        }
        return max;
    }

    private static int getNumber(int[] numbers, int start, int end) {
        int n = numbers[start];
        while (++start < end) {
            n *= 10;
            n += numbers[start];
        }
        return n;
    }

    @Test
    public void test() {
        assertEquals(36, MaxKProduct.maxKProduct(123, 2));
        assertEquals(123 * 4, MaxKProduct.maxKProduct(1234, 2));
        assertEquals(144, MaxKProduct.maxKProduct(1234, 3));
        assertEquals(2460, MaxKProduct.maxKProduct(12345, 3));
    }

}
