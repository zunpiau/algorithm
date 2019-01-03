package exercise.point_to_offer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 题目描述
 * 地上有一个m行和n列的方格。一个机器人从坐标 0,0 的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class RobotMoving {

    private static int sumBit(int a) {
        int res = 0;
        while (a > 0) {
            res += a % 10;
            a /= 10;
        }
        return res;
    }

    @Test
    public void test() {
        assertEquals(6, movingCount(2, 3, 3));
    }

    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] flags = new boolean[rows][cols];
        return movingCount(threshold, rows, cols, 0, 0, flags);
    }

    private int movingCount(int threshold, int rows, int cols, int row, int col, boolean[][] flags) {
        if (row < 0 || row >= rows || col < 0 || col >= cols
            || sumBit(row) + sumBit(col) > threshold || flags[row][col]) return 0;
        flags[row][col] = true;
        return 1 + movingCount(threshold, rows, cols, row + 1, col, flags)
               + movingCount(threshold, rows, cols, row - 1, col, flags)
               + movingCount(threshold, rows, cols, row, col + 1, flags)
               + movingCount(threshold, rows, cols, row, col - 1, flags);
    }
}
