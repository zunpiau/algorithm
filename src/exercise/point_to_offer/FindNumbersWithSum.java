package exercise.point_to_offer;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;

/**
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * <p>
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 */
public class FindNumbersWithSum {

    @Test
    public void test() {
        assertArrayEquals(new Integer[]{1, 6}, find(new int[]{1, 3, 4, 6, 8}, 7).toArray());
    }

    public ArrayList<Integer> find(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>(2);
        for (int i = 0, j = array.length - 1; i < j; ) {
            int s = array[i] + array[j];
            if (s == sum) {
                res.add(array[i]);
                res.add(array[j]);
                break;
            } else if (s > sum) j--;
            else i++;
        }
        return res;
    }

}
