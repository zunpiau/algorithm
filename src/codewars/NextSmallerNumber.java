package codewars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NextSmallerNumber {

    public static long nextSmaller(long n) {
        int length = String.valueOf(n).length();
        long[] bits = new long[length];
        long number = n;
        for (int i = length - 1; i >= 0; i--, number /= 10) {
            bits[i] = number % 10;
        }
        int biggerThenRightIndex = -1;
        for (int i = length - 2; i >= 0; i--) {
            if (bits[i] > bits[i + 1]) {
                biggerThenRightIndex = i;
                break;
            }
        }
        if (biggerThenRightIndex == -1)
            return -1;
        int biggestSmallerIndex = biggerThenRightIndex + 1;
        for (int i = biggestSmallerIndex + 1; i < length; i++) {
            if (bits[i] < bits[biggerThenRightIndex] && bits[i] >= bits[biggestSmallerIndex]) {
                biggestSmallerIndex = i;
            }
        }
        swap(bits, biggerThenRightIndex, biggestSmallerIndex);
        if (bits[0] == 0)
            return -1;
        for (int start = biggerThenRightIndex + 1, end = length - 1; start < end; start++, end--) {
            swap(bits, start, end);
        }
        long result = 0, bit = 1;
        for (int i = length - 1; i >= 0; i--, bit *= 10) {
            result += bits[i] * bit;
        }
        return result;
    }

    private static void swap(long[] array, int a, int b) {
        long t = array[a];
        array[a] = array[b];
        array[b] = t;
    }

    @Test
    public void basicTests() {
        assertEquals(105601446240491088L, NextSmallerNumber.nextSmaller(105601446240491808L));
        assertEquals(790, NextSmallerNumber.nextSmaller(907));
        assertEquals(20990, NextSmallerNumber.nextSmaller(29009));
        assertEquals(513, NextSmallerNumber.nextSmaller(531));
        assertEquals(-1, NextSmallerNumber.nextSmaller(1027));
        assertEquals(414, NextSmallerNumber.nextSmaller(441));
        assertEquals(123456789, NextSmallerNumber.nextSmaller(123456798));
    }

}
