package misc;

/*
 * https://www.v2ex.com/t/432309
 */
public class ClockwiseFlatMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {5, 19, 23, 16, 6},
                {10, 9, 17, 14, 4},
                {1, 2, 21, 13, 22},
                {16, 20, 8, 3, 11},
                {12, 15, 7, 18, 0}
        };
        int[] array = new ClockwiseFlatMatrix().flat(matrix);
        for (int i : array) {
            System.out.printf("%-3d", i);
        }
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
