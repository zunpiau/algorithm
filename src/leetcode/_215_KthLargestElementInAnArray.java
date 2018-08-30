package leetcode;

public class _215_KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int l = 0, r = nums.length - 1, p;
        while (l < r) {
            p = partition(nums, l, r);
            if (p < k) l = p + 1;
            else if (p > k) r = p - 1;
            else break;
        }
        return nums[k];
    }

    private int partition(int[] nums, int l, int r) {
        int i = l, j = r + 1, p = nums[l];
        do {
            do i++; while (i < r && nums[i] < p);
            do j--; while (j > l && nums[j] > p);
            swap(nums, i, j);
        } while (i < j);
        swap(nums, i, j);
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
