package leetcode;

public class _485_MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; ) {
            int j;
            for (j = i; j < nums.length && nums[j] == 1; j++)
                ;
            max = (j - i > max) ? j - i : max;
            i = j + 1;
        }
        return max;

    }
}
