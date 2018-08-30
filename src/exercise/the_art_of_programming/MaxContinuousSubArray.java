package exercise.the_art_of_programming;

import org.junit.Assert;
import org.junit.Test;

public class MaxContinuousSubArray {

    public static int maxSum(int[] numbers) {
        int maxSum = numbers[0];
        for (int i = 1, currentSum = numbers[0]; i < numbers.length; i++) {
            currentSum = Math.max(currentSum + numbers[i], numbers[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    @Test
    public void test() {
        Assert.assertEquals(18, MaxContinuousSubArray.maxSum(new int[]{1, -2, 3, 10, -4, 7, 2, -5}));
    }

}
