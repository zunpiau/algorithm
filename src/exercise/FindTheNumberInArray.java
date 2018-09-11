package exercise;

public class FindTheNumberInArray {

    /**
     * @see leetcode._136_SingleNumber
     * 数组中只有一个数字出现一次，其他数出现偶数次
     */
    public int singleNumber(int[] nums) {
        int xor = nums[0];
        for (int i = 1; i < nums.length; i++) {
            xor ^= nums[i];
        }
        return xor;
    }

    /**
     * https://www.v2ex.com/t/480886
     * 一个大小为 n 的数组，数组的内容为 0 ~ n-1 的任意数，这些数中有一个数出现了 1 次，其他数出现 0 次或多次，
     * 在 O(n)时间复杂度,O(1)空间复杂度内找到这个出现 1 次的数
     */
    //TODO
    public int findTheAppearOne(int[] array) {

        return 0;
    }

    /**
     * @see exercise.the_art_of_programming.FindMoreThenHalf#countFind(int[])
     * 找出数组中出现次数多于一半的数
     */
    public int findMoreThanHalfNum(int[] array) {
        int candidate = array[0], times = 1;
        for (int i = 1; i < array.length; i++) {
            if (times == 0) {
                candidate = array[i];
                times = 1;
            } else {
                if (array[i] == candidate)
                    times++;
                else
                    times--;
            }
        }
        return candidate;
    }

    /**
     * @see exercise.point_to_offer.MoreThanHalfNum#find(int[])
     * 找出数组中出现次数多于一半的数，如果不存在返回 <code>Integer.MIN_VALUE</code>;
     */
    public int findMoreThanHalfNumIfExist(int[] array) {
        if (array.length == 0) return 0;
        int candidate = array[0];
        for (int i = 1, times = 1; i < array.length; i++) {
            if (times == 0) {
                candidate = array[i];
                times = 1;
            } else {
                if (array[i] == candidate)
                    times++;
                else
                    times--;
            }
        }
        int time = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == candidate)
                time++;
        }
        if (time * 2 <= array.length)
            return Integer.MIN_VALUE;
        return candidate;
    }

}
