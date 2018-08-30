package exercise.point_to_offer;

import misc.FisherYatesShuffle;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class MoreThanHalfNum {

    @Test
    public void test() {
        Assert.assertEquals(0, find(new int[]{}));
        Assert.assertEquals(1, find(new int[]{1}));
        Assert.assertEquals(1, find(new int[]{1, 2, 1}));
        Assert.assertEquals(0, find(new int[]{1, 2, 1, 2}));
        Assert.assertEquals(0, find(new int[]{1, 2, 3, 2, 4, 2, 5, 2, 3}));
        Random random = new Random();
        FisherYatesShuffle shuffle = new FisherYatesShuffle();
        for (int i = 0; i < 20; i++) {
            int length = random.nextInt(98) + 2;
            int target = random.nextInt(100);
            int half = (length - 1) / 2;
            int[] array = new int[length];
            for (int j = 0; j < half; j++) {
                int r = random.nextInt(100);
                if (r == target)
                    r += random.nextInt(100) + 1;
                array[j] = r;
            }
            Arrays.fill(array, half, array.length, target);
            shuffle.shuffle(array);
            String message = Arrays.toString(array);
            Assert.assertEquals(message, target, find(array));
        }
        for (int i = 0; i < 20; i++) {
            int length = (random.nextInt(4) + 2) * 2;
            int target = random.nextInt(100);
            int half = length / 2;
            int[] array = new int[length];
            for (int j = 0; j < half; j++) {
                int r = random.nextInt(100);
                if (r == target)
                    r += random.nextInt(100) + 1;
                array[j] = r;
            }
            Arrays.fill(array, half, array.length, target);
            shuffle.shuffle(array);
            String message = Arrays.toString(array);
            Assert.assertEquals(message, 0, find(array));
        }
    }

    public int find(int[] array) {
        if (array.length == 0) return 0;
        int candidate = array[0];
        for (int i = 1, times = 1; i < array.length; i++) {
            if (times == 0) {
                candidate = array[i];
                times = 1;
            } else {
                if (array[i] == candidate)
                    times++;
                else
                    times--;
            }
        }
        int time = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == candidate)
                time++;
        }
        if (time * 2 <= array.length)
            return 0;
        return candidate;
    }

}
