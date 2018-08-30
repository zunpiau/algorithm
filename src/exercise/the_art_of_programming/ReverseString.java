package exercise.the_art_of_programming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://wizardforcel.gitbooks.io/the-art-of-programming-by-july/content/01.01.html
 */
public class ReverseString {

    /**
     * @param m 移动前 m 位字符到字符串尾
     */
    public static String leftRotateString(String s, int m) {
        m %= s.length();
        char[] chars = s.toCharArray();
        reverse(chars, 0, m - 1);
        reverse(chars, m, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        return new String(chars);
    }

    public static String reverseWord(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reverse(chars, start, i - 1);
                start = i + 1;
            }
        }
        reverse(chars, start, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        return new String(chars);
    }

    private static void reverse(char[] chars, int from, int to) {
        while (from < to) {
            char c = chars[from];
            chars[from++] = chars[to];
            chars[to--] = c;
        }
    }

    @Test
    public void testLeftRotateString() {
        assertEquals("bcdefa", ReverseString.leftRotateString("abcdef", 1));
        assertEquals("cdefab", ReverseString.leftRotateString("abcdef", 2));
        assertEquals("defabc", ReverseString.leftRotateString("abcdef", 3));
        assertEquals("efabcd", ReverseString.leftRotateString("abcdef", 4));
        assertEquals("fabcde", ReverseString.leftRotateString("abcdef", 5));
        assertEquals("abcdef", ReverseString.leftRotateString("abcdef", 6));
    }

    @Test
    public void testReverseWord() {
        assertEquals("student a am I", ReverseString.reverseWord("I am a student"));
        assertEquals("am I", ReverseString.reverseWord("I am"));
        assertEquals("I", ReverseString.reverseWord("I"));
    }

}
