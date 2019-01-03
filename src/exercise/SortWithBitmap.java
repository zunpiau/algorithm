package exercise;

import org.junit.Test;

import java.util.BitSet;

import static org.junit.Assert.assertArrayEquals;

public class SortWithBitmap {

    @Test
    public void test() {
        assertArrayEquals(new int[]{1, 3, 4}, sort(new int[]{1, 3, 4}));
        assertArrayEquals(new int[]{0, 63}, sort(new int[]{63, 0}));

        assertArrayEquals(new int[]{1, 3, 4}, sortWithBitSet(new int[]{1, 3, 4}));
        assertArrayEquals(new int[]{0, 253}, sortWithBitSet(new int[]{253, 0}));
    }

    /**
     * n 个无重复的正整数, 0 <= n < 64
     */
    public int[] sort(int[] array) {
        long bitmap = 0L;
        for (int i : array) {
            bitmap |= 1L << i;
        }
        int[] res = new int[array.length];
        for (int i = 0, j = 0; i < array.length; j++, bitmap >>>= 1) {
            if ((bitmap & 1) == 1) {
                res[i] = j;
                i++;
            }
        }
        return res;
    }

    public int[] sortWithBitSet(int[] array) {
        BitSet bitSet = new BitSet();
        for (int i : array) {
            bitSet.set(i);
        }
        int[] res = new int[array.length];
        for (int i = 0, j = 0; i < array.length; j++) {
            if (bitSet.get(j)) {
                res[i] = j;
                i++;
            }
        }
        return res;
    }
}
