package codewars;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/*
 * https://www.v2ex.com/t/432309
 */
public class ClockwiseFlatMatrix {

    @Test
    public void test() {
        assertArrayEquals(new int[]{1, 2, 3}, flat(new int[][]{{1, 2, 3}}));
        assertArrayEquals(new int[]{1, 2, 3}, flat(new int[][]{{1}, {2}, {3}}));
        assertArrayEquals(new int[]{}, flat(new int[][]{}));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, flat(new int[][]{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}}));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, flat(new int[][]{{1, 2, 3}, {6, 5, 4}}));
        assertArrayEquals(new int[]{1, 2, 4, 3}, flat(new int[][]{{1, 2}, {3, 4}}));
    }

    public int[] flat(int[][] matrix) {
        int width = matrix[0].length;
        int height = matrix.length;
        int[] array = new int[width * height];
        for (int circleIndex = 0, circle = (Math.min(width, height) + 1) / 2, x = 0, y = 0, previousLength = 0;
             circleIndex < circle;
             circleIndex++) {
            int perimeter = calPerimeter(width, height);
            for (int i = 0; i < perimeter; i++) {
                array[i + previousLength] = matrix[x + circleIndex][y + circleIndex];
                if (i < width - 1 && x == 0) y++;
                else if (i < width + height - 2 && y == width - 1) x++;
                else if (i < 2 * width + height - 3 && x == height - 1) y--;
                else x--;
            }
            previousLength += perimeter;
            width = width - 2;
            height = height - 2;
        }
        return array;
    }

    private int calPerimeter(int width, int height) {
        if (width == 1 || height == 1)
            return width * height;
        else
            return 2 * (width + height) - 4;
    }

}
