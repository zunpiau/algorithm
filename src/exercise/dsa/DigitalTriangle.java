package exercise.dsa;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class DigitalTriangle {

    public static int getMaxPath(int[][] triangle) {
        int row = triangle.length;
        int col = triangle[row - 1].length;
        int[][] sum = new int[row][col];
        sum[0][0] = triangle[0][0];
        for (int i = 1; i < row; i++) {
            sum[i][0] = triangle[i][0] + sum[i - 1][0];
            for (int j = 1; j < i; j++) {
                sum[i][j] = triangle[i][j] + Math.max(sum[i - 1][j], sum[i - 1][j - 1]);
            }
            sum[i][i] = triangle[i][i] + sum[i - 1][i - 1];
        }
        int max = sum[row - 1][0];
        for (int i = 1; i < col; i++) {
            max = Math.max(max, sum[row - 1][i]);
        }
        return max;
    }

    public static int getMaxPath(int[] triangle, int lines) {
        int[] sum = new int[triangle.length];
        sum[0] = triangle[0];
        for (int line = 1; line < lines; line++) {
            sum[getPosition(line, 0)] = sum[getPosition(line - 1, 0)] + triangle[getPosition(line, 0)];
            for (int i = 1; i < line; i++) {
                sum[getPosition(line, i)] = Math.max(sum[getPosition(line - 1, i)], sum[getPosition(line - 1, i - 1)]) + triangle[getPosition(line, i)];
            }
            sum[getPosition(line, line)] = sum[getPosition(line - 1, line - 1)] + triangle[getPosition(line, line)];
        }
        System.out.println(Arrays.toString(sum));
        int max = sum[sum.length - 1];
        for (int i = sum.length - 2; i >= sum.length - lines; i--) {
            max = Math.max(max, sum[i]);
        }
        return max;
    }

    private static int getPosition(int line, int col) {
        return (line + 1) * line / 2 + col;
    }

    @Test
    public void test() {
        Assert.assertEquals(29, DigitalTriangle.getMaxPath(new int[][]{{5}, {9, 6}, {2, 7, 3}, {1, 8, 4, 0}}));
        Assert.assertEquals(29, DigitalTriangle.getMaxPath(new int[]{5, 9, 6, 2, 7, 3, 1, 8, 4, 0}, 4));
    }

}
