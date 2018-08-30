package exercise.point_to_offer;

import org.junit.Assert;
import org.junit.Test;

public class MinNumberInRotateArray {

    public static int find(int[] array) {
        if (array == null || array.length == 0) return 0;
        int start = 0;
        for (int end = array.length - 1; start < end; ) {
            if (array[start] < array[end])
                return array[start];
            int mid = (start + end) / 2;
            if (array[mid] > array[start])
                start = mid;
            else if (array[mid] < array[end])
                end = mid;
            else
                start++;
        }
        return array[start];
    }

    @Test
    public void test() {
        Assert.assertEquals(0, find(null));
        Assert.assertEquals(0, find(new int[0]));
        Assert.assertEquals(1, find(new int[]{1}));
        Assert.assertEquals(1, find(new int[]{3, 4, 5, 1, 2}));
        Assert.assertEquals(1, find(new int[]{3, 4, 5, 1, 2, 2}));
        Assert.assertEquals(1, find(new int[]{3, 4, 5, 1, 1, 2}));
        Assert.assertEquals(1, find(new int[]{1, 2, 3, 4, 5}));
        Assert.assertEquals(0, find(new int[]{1, 0, 1, 1, 1}));
        Assert.assertEquals(0, find(new int[]{1, 1, 1, 0, 1}));
    }

}
