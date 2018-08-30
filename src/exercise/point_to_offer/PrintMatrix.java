package exercise.point_to_offer;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;

public class PrintMatrix {

    @Test
    public void test() {
        Integer[] integers = new Integer[0];
        assertArrayEquals(new Integer[]{1, 2, 3}, printMatrix(new int[][]{{1, 2, 3}}).toArray(integers));
        assertArrayEquals(new Integer[]{1, 2, 3}, printMatrix(new int[][]{{1}, {2}, {3}}).toArray(integers));
        assertArrayEquals(new Integer[]{}, printMatrix(new int[][]{}).toArray(integers));
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, printMatrix(new int[][]{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}}).toArray(integers));
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6}, printMatrix(new int[][]{{1, 2, 3}, {6, 5, 4}}).toArray(integers));
        assertArrayEquals(new Integer[]{1, 2, 4, 3}, printMatrix(new int[][]{{1, 2}, {3, 4}}).toArray(integers));
    }

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return new ArrayList<>(1);
        int height = matrix.length;
        int width = matrix[0].length;
        ArrayList<Integer> list = new ArrayList<>(width * height);
        for (int circleIndex = 0, circle = (Math.min(width, height) + 1) / 2, x = 0, y = 0;
             circleIndex < circle;
             circleIndex++) {
            int perimeter = calPerimeter(width, height);
            for (int i = 0; i < perimeter; i++) {
                list.add(matrix[x + circleIndex][y + circleIndex]);
                if (i < width - 1 && x == 0) y++;
                else if (i < width + height - 2 && y == width - 1) x++;
                else if (i < 2 * width + height - 3 && x == height - 1) y--;
                else x--;
            }
            width = width - 2;
            height = height - 2;
        }
        return list;
    }

    private int calPerimeter(int width, int height) {
        if (width == 1 || height == 1)
            return width * height;
        else
            return 2 * (width + height) - 4;
    }

}
