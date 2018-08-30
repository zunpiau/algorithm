package leetcode;

public class _344_ReverseString {

    public String reverseString_2(String s) {
        char[] c = s.toCharArray();
        char t;
        int length = c.length, half = length / 2;
        for (int i = 0; i < half; i++) {
            t = c[i];
            c[i] = c[length - 1 - i];
            c[length - 1 - i] = t;
        }
        return new String(c);
    }

    public String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
