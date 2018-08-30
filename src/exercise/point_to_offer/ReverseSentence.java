package exercise.point_to_offer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseSentence {

    @Test
    public void test() {
        assertEquals("", reverse(""));
        assertEquals("student", reverse("student"));
        assertEquals("I am a student.", reverse("student. a am I"));
        assertEquals("I am a  student.", reverse("student.  a am I"));
    }

    public String reverse(String str) {
        char[] chars = str.toCharArray();
        int lastSpace = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reverse(chars, lastSpace + 1, i - 1);
                lastSpace = i;
            }
        }
        reverse(chars, lastSpace + 1, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        char t;
        for (; start < end; start++, end--) {
            t = chars[start];
            chars[start] = chars[end];
            chars[end] = t;
        }
    }
}
