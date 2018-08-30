package exercise.nowcoder;

import java.util.Arrays;

public class MoveFriends {

    public static void main(String[] args) {
        System.out.println(MoveFriends.minDistance(new int[]{4, 7, 7}, 5));
    }

    public static int minDistance(int[] pos, int distance) {
        Arrays.sort(pos);
        int min = pos[0], max = pos[pos.length - 1];
        return Math.min(Math.abs(max - min - 2 * distance), Math.abs(max - distance - min));
    }

}
