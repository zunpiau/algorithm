package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class _406_QueueReconstructionByHeight {

    public static void main(String[] args) {
        int[][] people = new _406_QueueReconstructionByHeight().reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
        for (int[] ints : people) {
            System.out.println(ints[0] + " " + ints[1]);
        }
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0])
                return Integer.compare(o1[1], o2[1]);
            return -Integer.compare(o1[0], o2[0]);
        });
        ArrayList<int[]> list = new ArrayList<>(people.length);
        for (int[] aPeople : people) {
            list.add(aPeople[1], new int[]{aPeople[0], aPeople[1]});
        }
        return list.toArray(new int[][]{});
    }

}
