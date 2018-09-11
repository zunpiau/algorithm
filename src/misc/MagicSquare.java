package misc;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;

/**
 * <a href="http://www.mathsgreat.com/magic_sq/magic_sq.html">幻 方</a>
 * <a href="https://flysands.github.io/blog/2017-01-29-%E4%B9%9D%E5%AE%AB%E6%A0%BC%E9%97%AE%E9%A2%98.html">九宫格问题</a>
 */

public class MagicSquare {

    public static int[][] getMagicSquare(int n) {
        assert n >= 3;
        if (n % 2 == 1) {
            return oddOrder(n);
        } else if (n % 4 == 0) {
            return doublyEvenOrder(n);
        } else {
            return singlyEvenOrder(n);
        }
    }

    public static int[][] singlyEvenOrder(int n) {
        assert n >= 6 && n % 2 == 0 && n % 4 != 0;
        int[][] square = new int[n][n];
        int half = n / 2;
        int squareHalf = half * half;
        oddOrder(square, 0, 0, half, 0);
        oddOrder(square, half, half, half, squareHalf);
        oddOrder(square, 0, half, half, 2 * squareHalf);
        oddOrder(square, half, 0, half, 3 * squareHalf);

        int m = (n - 2) / 4;
        int quarter = half / 2;
        for (int i = 0; i < half; i++) {
            for (int j = 0; j < m; j++) {
                swap(square, i, j, i + half, j);
            }
        }
        swap(square, quarter, m - 1, quarter + half, m - 1);
        swap(square, quarter, m, quarter + half, m);
        for (int i = 0; i < half; i++) {
            for (int j = 1; j <= m - 1; j++) {
                swap(square, i, n - j, i + half, n - j);
            }
        }
        return square;
    }

    public static int[][] doublyEvenOrder(int n) {
        assert n % 4 == 0;
        int[][] square = new int[n][n];
        int region = n / 4;
        for (int i = 0; i < region; i++) {
            for (int j = 0; j < region; j++) {
                doublyEvenOrder(square, i, j);
            }
        }
        return square;
    }

    private static void doublyEvenOrder(int[][] square, int regionX, int regionY) {
        int length = square.length;
        for (int i = 0, x = regionX * 4, y = regionY * 4, max = length * length; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j || i + j == 3) {
                    square[x + i][y + j] = max - (length * (x + i) + (y + j));
                } else {
                    square[x + i][y + j] = 1 + length * (x + i) + (y + j);
                }
            }
        }
    }

    public static int[][] oddOrder(int n) {
        assert n >= 3 && n % 2 == 1;
        int[][] square = new int[n][n];
        oddOrder(square, 0, 0, n, 0);
        return square;
    }

    private static void oddOrder(int[][] square, int x, int y, int n, int added) {
        int row = x, col = y + n / 2;
        square[row][col] = 1 + added;
        for (int i = 2, max = n * n; i <= max; i++) {
            int xt = x + (row - x + n - 1) % n;
            int yt = y + (col - y + 1) % n;
            if (square[xt][yt] != 0) {
                yt = col;
                xt = row + 1;
                while (square[xt][yt] != 0)
                    xt = (xt + 1) % n;
            }
            square[xt][yt] = square[row][col] + 1;
            row = xt;
            col = yt;
        }
    }

    private static void swap(int[][] square, int x1, int y1, int x2, int y2) {
        int t = square[x1][y1];
        square[x1][y1] = square[x2][y2];
        square[x2][y2] = t;
    }

    private static boolean isMagicSquare(int[][] square) {
        int length = square.length;
        long[] row = new long[length];
        long[] col = new long[length];
        long counterDiagonal = 0, diagonal = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                row[i] += square[i][j];
                col[j] += square[i][j];
                if (i == j) diagonal += square[i][j];
                if (i + j == length - 1) counterDiagonal += square[i][j];
            }
        }
        long sum = length * (((long) length) * length + 1) / 2;
        for (long i : row) {
            if (i != sum)
                return false;
        }
        for (long i : col) {
            if (i != sum)
                return false;
        }
        return sum == counterDiagonal && sum == diagonal;
    }

    private static void print(int[][] n) {
        for (int[] ints : n) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
    }

    @Test
    public void test() {
        for (int i = 3; i <= 18; i++) {
            assertTrue(isMagicSquare(getMagicSquare(i)));
        }
    }

}
