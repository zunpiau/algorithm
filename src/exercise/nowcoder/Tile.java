package exercise.nowcoder;

public class Tile {

    public static void main(String[] args) {
        int length = 20;
        int[] n = new int[length + 1];
        n[1] = 1;
        n[2] = 1;
        n[3] = 2;
        for (int i = 4; i <= length; i++) {
            n[i] = n[i - 1] + n[i - 3];
            System.out.println(i + " " + n[i]);
        }
    }

}
