package exercise.point_to_offer;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 题目描述
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，
 * 每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如 a b c e s f c s a d e e 这样的 3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子
 */
public class PathInMatrix {

    private static boolean hasPath(char[] matrix, int rows, int cols, char[] str, int row, int col, int index) {
        int indexInMatrix = row * cols + col;
        if (row < 0 || row >= rows || col < 0 || col >= cols || matrix[indexInMatrix] != str[index]) return false;
        if (index == str.length - 1) return true;
        char t = matrix[indexInMatrix];
        matrix[indexInMatrix] = Character.MIN_SURROGATE;
        if (hasPath(matrix, rows, cols, str, row - 1, col, index + 1) ||
            hasPath(matrix, rows, cols, str, row + 1, col, index + 1)
            || hasPath(matrix, rows, cols, str, row, col - 1, index + 1) ||
            hasPath(matrix, rows, cols, str, row, col + 1, index + 1))
            return true;
        matrix[indexInMatrix] = t;
        return false;
    }

    @Test
    public void test() {
        char[] matrix = {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        assertTrue(hasPath(matrix, 3, 4, "bcced".toCharArray()));
        assertFalse(hasPath(matrix, 3, 4, "abcb".toCharArray()));
        assertFalse(hasPath("abc".toCharArray(), 1, 3, "abcd".toCharArray()));
    }

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i * cols + j] == str[0] && hasPath(matrix, rows, cols, str, i, j, 0))
                    return true;
            }
        }
        return false;
    }
}
