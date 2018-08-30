package leetcode;

public class _665_NonDecreasingArray {

    public static void main(String[] args) {
        System.out.println(new _665_NonDecreasingArray().checkPossibility(new int[]{1, 6, 6, 3, 7}));
    }

    public boolean checkPossibility(int[] nums) {
        int modify = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (i >= 2 && nums[i] < nums[i - 2])
                    nums[i] = nums[i - 1];
                else
                    nums[i - 1] = nums[i];
                if (++modify > 1)
                    return false;
            }
        }
        return true;
    }

}
