package exercise.point_to_offer;

import org.junit.Assert;
import org.junit.Test;

public class GetNumberOfK {

    @Test
    public void testGetFirstK() {
        Assert.assertEquals(-1, getFirstK(new int[]{}, 1));
        Assert.assertEquals(0, getFirstK(new int[]{1}, 1));
        Assert.assertEquals(0, getFirstK(new int[]{1, 1, 1}, 1));
        Assert.assertEquals(1, getFirstK(new int[]{0, 1, 1, 1}, 1));
        Assert.assertEquals(3, getFirstK(new int[]{0, 0, 0, 1}, 1));
        Assert.assertEquals(2, getFirstK(new int[]{0, 0, 1, 1}, 1));
    }

    @Test
    public void testGetLastK() {
        Assert.assertEquals(-1, getLastK(new int[]{}, 1));
        Assert.assertEquals(0, getLastK(new int[]{1}, 1));
        Assert.assertEquals(2, getLastK(new int[]{1, 1, 1}, 1));
        Assert.assertEquals(3, getLastK(new int[]{0, 1, 1, 1}, 1));
        Assert.assertEquals(3, getLastK(new int[]{0, 0, 0, 1}, 1));
        Assert.assertEquals(2, getLastK(new int[]{0, 0, 1, 2}, 1));
    }

    public int getNumberOfK(int[] array, int k) {
        int first = getFirstK(array, k);
        if (first == -1)
            return 0;
        int last = getLastK(array, k);
        return last - first + 1;
    }

    private int getFirstK(int[] array, int k) {
        int l = 0, r = array.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (array[mid] > k) {
                r = mid - 1;
            } else if (array[mid] < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (array.length == 0 || array[l] != k)
            return -1;
        return l;
    }

    private int getLastK(int[] array, int k) {
        int l = 0, r = array.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (array[mid] > k) {
                r = mid - 1;
            } else if (array[mid] < k) {
                l = mid + 1;
            } else {
                if (mid + 1 < array.length && array[mid + 1] == k)
                    l = mid + 1;
                else
                    return mid;
            }
        }
        return -1;
    }

}
