package exercise.point_to_offer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LastRemaining {

    public static int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) return -1;
        if (m == 1) return n - 1;
        int k = n - 1;
        for (k = k * m + m - 1; k >= n; k = k - n + (k - n) / (m - 1)) ;
        return k;
    }

    @Test
    public void test() {
        assertEquals(-1, LastRemaining_Solution(0, 0));
        assertEquals(0, LastRemaining_Solution(1, 1));
        assertEquals(0, LastRemaining_Solution(1, 2));
        assertEquals(-1, LastRemaining_Solution(2, 0));
        assertEquals(1, LastRemaining_Solution(2, 1));
        assertEquals(0, LastRemaining_Solution(2, 4));
        assertEquals(1, LastRemaining_Solution(9, 7));
        assertEquals(2, LastRemaining_Solution(9, 8));
    }

}
