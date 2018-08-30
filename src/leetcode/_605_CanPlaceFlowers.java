package leetcode;

public class _605_CanPlaceFlowers {

    public static void main(String[] args) {
        System.out.println(new _605_CanPlaceFlowers().canPlaceFlowers(new int[]{0}, 1));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 1)
            return n <= 1 - flowerbed[0];
        int count = 0;
        for (int i = 0; i < flowerbed.length - 1; i += 2) {
            if (flowerbed[i] == 0) {
                if (flowerbed[i + 1] == 1)
                    i++;
                else {
                    count++;
                    flowerbed[i] = 1;
                }
            }
        }
        if (flowerbed[flowerbed.length - 1] + flowerbed[flowerbed.length - 2] == 0)
            count++;
        return n <= count;
    }
}
