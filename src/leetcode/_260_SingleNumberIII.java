package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class _260_SingleNumberIII {

    @Test
    public void test() {
        Assert.assertEquals(15, multi(singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
        Assert.assertEquals(15, multi(singleNumber(new int[]{1, 1, 3, 5})));
        Assert.assertEquals(12, multi(singleNumber(new int[]{4, 3})));
    }

    private int multi(int[] twoNumbers) {
        return twoNumbers[0] * twoNumbers[1];
    }

    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int lowestOneBit = xor & -xor;
        int[] res = new int[2];
        for (int num : nums) {
            if ((num & lowestOneBit) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }

}
