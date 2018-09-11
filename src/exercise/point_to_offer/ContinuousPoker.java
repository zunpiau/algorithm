package exercise.point_to_offer;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ContinuousPoker {

    @Test
    public void test() {
        assertFalse(isContinuous(new int[]{}));
        assertTrue(isContinuous(new int[]{1, 2, 3, 4, 5}));
        assertTrue(isContinuous(new int[]{1, 2, 0, 0, 5}));
        assertTrue(isContinuous(new int[]{4, 3, 0, 0, 5}));
        assertFalse(isContinuous(new int[]{8, 3, 0, 0, 5}));
        assertFalse(isContinuous(new int[]{3, 3, 0, 0, 5}));
    }

    public boolean isContinuous(int[] numbers) {
        if (numbers.length != 5) return false;
        int max = -1, min = 14;
        long count = 0;
        for (int number : numbers) {
            if (number == 0) continue;
            if (((count >>> number) & 1) == 1) return false;
            count |= (1L << number);
            min = min < number ? min : number;
            max = max > number ? max : number;
        }
        return max - min < 5;
    }

}
