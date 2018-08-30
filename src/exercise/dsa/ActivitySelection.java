package exercise.dsa;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ActivitySelection {

    public static int[] select(int[] start, int[] finish) {
        List<Integer> target = new ArrayList<>();
        int lastFinish = finish[0];
        target.add(0);
        while (true) {
            int minStartIndex = Integer.MAX_VALUE;
            for (int i = 1; i < start.length; i++) {
                if (start[i] == lastFinish) {
                    minStartIndex = i;
                    break;
                } else if (start[i] > lastFinish && (minStartIndex == Integer.MAX_VALUE || finish[i] < finish[minStartIndex])) {
                    minStartIndex = i;
                }
            }
            if (minStartIndex == Integer.MAX_VALUE)
                break;
            target.add(minStartIndex);
            lastFinish = finish[minStartIndex];
        }
        return listToArray(target);
    }

    private static int[] listToArray(List<Integer> list) {
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{0, 3, 7, 10}, ActivitySelection.select(
                new int[]{1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12},
                new int[]{4, 5, 6, 7, 9, 9, 10, 11, 12, 14, 16}));
    }

}
