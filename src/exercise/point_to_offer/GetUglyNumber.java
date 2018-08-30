package exercise.point_to_offer;

public class GetUglyNumber {

    public int GetUglyNumber_Solution(int index) {
        int[] hammingNumbers = new int[index];
        int[] x = {2, 3, 5};
        int[] count = {0, 0, 0};
        int[] multiFactor = {2, 3, 5};
        hammingNumbers[0] = 1;
        for (int l = 1; l < index; l++) {
            hammingNumbers[l] = Math.min(x[0], Math.min(x[1], x[2]));
            for (int i = 0; i < 3; i++) {
                if (hammingNumbers[l] == x[i])
                    x[i] = multiFactor[i] * hammingNumbers[++count[i]];
            }
        }
        return hammingNumbers[hammingNumbers.length - 1];
    }

}
