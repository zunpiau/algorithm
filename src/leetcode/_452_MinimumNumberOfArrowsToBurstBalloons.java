package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class _452_MinimumNumberOfArrowsToBurstBalloons {

    public static void main(String[] args) {
        int[][] points = new int[][]{
                {10, 16}, {2, 8}, {1, 6}, {7, 17}, {18, 20}
        };
        System.out.println(3 == new _452_MinimumNumberOfArrowsToBurstBalloons().findMinArrowShots(points));
    }

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int arrow = 1;
        for (int i = 1, point = points[0][1]; i < points.length; i++) {
            if (points[i][0] <= point)
                continue;
            point = points[i][1];
            arrow++;
        }
        return arrow;
    }

}
