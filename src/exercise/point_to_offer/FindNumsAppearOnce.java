package exercise.point_to_offer;

public class FindNumsAppearOnce {

    public void find(int[] array, int num1[], int num2[]) {
        int xor = 0;
        for (int num : array) {
            xor ^= num;
        }
        int lowestOneBit = xor & -xor;
        for (int num : array) {
            if ((num & lowestOneBit) == 0) {
                num1[0] ^= num;
            } else {
                num2[0] ^= num;
            }
        }
    }
}
