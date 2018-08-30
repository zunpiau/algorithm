package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class _136_SingleNumber {

    @Test
    public void test() {
        Assert.assertEquals(1, singleNumber(new int[]{1, 2, 2}));
        Assert.assertEquals(4, singleNumber(new int[]{4, 1, 2, 1, 2}));
    }

    public int singleNumber(int[] nums) {
        int xor = nums[0];
        for (int i = 1; i < nums.length; i++) {
            xor ^= nums[i];
        }
        return xor;
    }

}
