package exercise.the_art_of_programming;

import misc.FisherYatesShuffle;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class FindMoreThenHalf {

    public static int sortFind(int[] array) {
        Arrays.sort(array);
        return array[array.length / 2];
    }

    public static int hashFind(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() > array.length / 2)
                return entry.getKey();
        }
        return -1;
    }

    public static int deleteFind(int[] array) {
        int i, j;
        for (i = 0, j = array.length - 1; i <= j - 2; i++) {
            if (array[i] != array[j]) {
                j--;
            }
        }
        if (array[i] == array[j]) return array[i];
        return array[i + 1];
    }

    public static int countFind(int[] array) {
        int candidate = array[0], times = 1;
        for (int i = 1; i < array.length; i++) {
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
        return candidate;
    }

    //TODO
    public static int findTheHalf(int[] array) {

        return 0;
    }

    @Test
    public void testFindMoreThenHalf() {
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
            Assert.assertEquals(message, target, sortFind(array));
            Assert.assertEquals(message, target, hashFind(array));
            Assert.assertEquals(message, target, deleteFind(array));
            Assert.assertEquals(message, target, countFind(array));
        }
    }

}
