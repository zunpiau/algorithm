package exercise.point_to_offer;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FindInMatrix {

    @Test
    public void test() {
        assertFalse(Find(0, new int[][]{}));
        assertFalse(Find(4, new int[][]{{1, 2, 3}}));
        assertTrue(Find(2, new int[][]{{1, 2, 3}}));
        assertTrue(Find(5, new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}}));
    }

    public boolean Find(int target, int[][] array) {
        if (array.length == 0) return false;
        for (int row = array.length - 1, col = 0; row >= 0 && col < array[0].length; ) {
            if (array[row][col] == target) return true;
            if (array[row][col] < target) col++;
            else row--;
        }
        return false;
    }
}
