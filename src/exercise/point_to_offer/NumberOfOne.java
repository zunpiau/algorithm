package exercise.point_to_offer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberOfOne {

    @Test
    public void test() {
        NumberOfOne numberOfOne = new NumberOfOne();
        for (int i = 0; i < 16; i++) {
            int max = Integer.MAX_VALUE - i;
            int min = Integer.MIN_VALUE + i;
            assertEquals(Integer.bitCount(max), numberOfOne.NumberOf1(max));
            assertEquals(Integer.bitCount(min), numberOfOne.NumberOf1(min));
            assertEquals(Integer.bitCount(i), numberOfOne.NumberOf1(i));
            assertEquals(Integer.bitCount(-i), numberOfOne.NumberOf1(-i));
        }
    }

    public int NumberOf1(int n) {
        int count = 0;
        if (n < 0) {
            n &= 0x7fffffff;
            count++;
        }
        while (n >= 1) {
            count += n % 2;
            n /= 2;
        }
        return count;
    }

}
