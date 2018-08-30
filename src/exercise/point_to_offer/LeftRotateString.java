package exercise.point_to_offer;

import org.junit.Assert;
import org.junit.Test;

public class LeftRotateString {

    @Test
    public void test() {
        Assert.assertEquals("XYZdefabc", rotate("abcXYZdef", 3));
        Assert.assertEquals("abcXYZdef", rotate("abcXYZdef", 0));
        Assert.assertEquals("", rotate("", 5));
    }

    public String rotate(String str, int n) {
        if (n == 0) return str;
        if (str == null || str.equals("")) return "";
        n %= str.length();
        char[] chars = str.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int from, int to) {
        while (from < to) {
            char c = chars[from];
            chars[from++] = chars[to];
            chars[to--] = c;
        }
    }

}
