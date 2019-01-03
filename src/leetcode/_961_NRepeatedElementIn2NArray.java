package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Date: 2018-12-25
 * Title: N-Repeated Element in Size 2N Array
 * Url: https://leetcode.com/problems/n-repeated-element-in-size-2n-array/
 * Description:
 * In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.
 * Return the element repeated N times.
 * <p>
 * Example:
 * Input: [1,2,3,3]
 * Output: 3
 * <p>
 * Input: [5,1,5,2,5,3,5,4]
 * Output: 5
 * <p>
 * Note:
 * 4 <= A.length <= 10000
 * 0 <= A[i] < 10000
 * A.length is even
 */
public class _961_NRepeatedElementIn2NArray {

    public static int repeatedNTimes(int[] A) {
        for (int d = 1; d <= 3; d++) {
            for (int i = A.length - 1; i >= d; i--) {
                if (A[i] == A[i - d])
                    return A[i];
            }
        }
        throw new IllegalStateException();
    }

    @Test
    public void test() {
        assertEquals(3, repeatedNTimes(new int[]{1, 2, 3, 3}));
        assertEquals(3, repeatedNTimes(new int[]{1, 3, 2, 3}));
        assertEquals(3, repeatedNTimes(new int[]{3, 1, 2, 3}));
        assertEquals(3, repeatedNTimes(new int[]{3, 1, 2, 3, 4, 3}));
    }

}
