package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _137_SingleNumberII {

    @Test
    public void test() {
        assertEquals(3, singleNumber(new int[]{4, 3, 4, 4}));
        assertEquals(99, singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));
        assertEquals(-4, singleNumber(new int[]{-2, -2, 1, 1, -3, 1, -3, -3, -4, -2}));
    }

    public int singleNumber(int[] nums) {
        int[] bit = new int[32];
        for (int num : nums) {
            for (int j = 0; j < bit.length; j++) {
                bit[j] += ((num >> j) & 1);
            }
        }
        int target = 0;
        for (int i = 0; i < bit.length; i++) {
            if (bit[i] % 3 != 0) {
                target += (1 << i);
            }
        }
        return target;
    }

}
