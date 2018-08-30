package exercise.point_to_offer;

public class NumberOfOne {

    public static void main(String[] args) {
        NumberOfOne numberOfOne = new NumberOfOne();
        for (int i = 0; i < 100; i++) {
            if (numberOfOne.NumberOf1(i) != Integer.bitCount(i))
                System.out.println(i + " " + Integer.toBinaryString(i));
        }
        for (int i = -100; i < 0; i++) {
            if (numberOfOne.NumberOf1(i) != Integer.bitCount(i)) {
                System.out.println(i + " " + Integer.toHexString(i));
            }
        }
    }

    public int NumberOf1(int n) {
        int count = 0;
        if (n < 0) {
            n &= 0x7fffffff;
            count++;
        }
        while (n >= 1) {
            count += n % 2;
            n /= 2;
        }
        return count;
    }

}
