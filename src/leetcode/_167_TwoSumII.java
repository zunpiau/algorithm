package leetcode;

import java.util.Arrays;

public class _167_TwoSumII {

    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0, key; i < numbers.length; i++) {
            if ((key = Arrays.binarySearch(numbers, i + 1, numbers.length, target - numbers[i])) >= 0)
                return new int[]{i + 1, key + 1};
        }
        return null;
    }

}
