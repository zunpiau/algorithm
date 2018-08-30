package codewars;

public class TripleTrouble {

    public static void main(String[] args) {
        System.out.println(TripleTrouble.tripleDouble(21110001L, 10010L));
    }

    public static int tripleDouble(long num1, long num2) {
        long triple = -1;
        int length = 0;
        for (; num1 > 0; num1 /= 10) {
            if (triple == num1 % 10) {
                if (++length == 3)
                    break;
            } else {
                triple = num1 % 10;
                length = 1;
            }
        }
        if (length < 3)
            return 0;
        for (boolean match = false; num2 > 0; num2 /= 10) {
            if (num2 % 10 == triple) {
                if (match) {
                    return 1;
                } else {
                    match = true;
                }
            } else {
                match = false;
            }
        }
        return 0;
    }

}
