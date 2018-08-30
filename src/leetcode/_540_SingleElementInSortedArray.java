package leetcode;

public class _540_SingleElementInSortedArray {

    public static void main(String[] args) {
        int[][] testCases = new int[][]{
                {1, 1, 2, 2, 3},
                {1, 1, 2, 3, 3, 4, 4, 8, 8},
                {1, 3, 3, 4, 4, 8, 8},
        };
        _540_SingleElementInSortedArray singleElementInSortedArray = new _540_SingleElementInSortedArray();
        for (int[] testCase : testCases) {
            System.out.println(singleElementInSortedArray.singleNonDuplicate(testCase));
        }

    }

    public int singleNonDuplicate(int[] nums) {
        int l = 0, h = nums.length - 1, mid;
        while (l < h) {
            mid = l + (h - l) / 2;
            if (mid % 2 == 1) mid--;
            if (nums[mid] == nums[mid + 1]) l = mid + 2;
            else h = mid;
        }
        return nums[l];
    }
}
