package leetcode;

import java.util.Arrays;

public class _575_DistributeCandies {

    public static void main(String[] args) {
        System.out.println(new _575_DistributeCandies().distributeCandies(new int[]{1, 1, 2, 2, 3, 3}));
    }

    public int distributeCandies(int[] candies) {
        return Math.min((int) Arrays.stream(candies).distinct().count(), candies.length / 2);
    }

}
