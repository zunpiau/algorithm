package exercise.point_to_offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import static org.junit.Assert.assertArrayEquals;

public class GetLeastNumbers {

    @Test
    public void test() {
        assertArrayEquals(new Integer[]{4}, GetLeastNumbers_Solution(new int[]{4}, 1).toArray());
        assertArrayEquals(new Integer[]{1, 2, 3, 4},
                GetLeastNumbers_Solution(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 4).toArray());
        assertArrayEquals(new Integer[]{},
                GetLeastNumbers_Solution(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 9).toArray());
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || input.length == 0 || k <= 0 || k > input.length) return list;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.naturalOrder());
        for (int anInput : input) {
            queue.add(anInput);
        }
        for (int i = 0; i < k; i++) {
            list.add(queue.poll());
        }
        return list;
    }
}
