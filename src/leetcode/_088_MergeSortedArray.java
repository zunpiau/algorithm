package leetcode;

public class _088_MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m - 1, j = n - 1, index = n + m - 1; i >= 0 || j >= 0; index--) {
            if (i < 0)
                nums1[index] = nums2[j--];
            else if (j < 0)
                nums1[index] = nums1[i--];
            else if (nums1[i] < nums2[j])
                nums1[index] = nums2[j--];
            else
                nums1[index] = nums1[i--];
        }
    }

}
