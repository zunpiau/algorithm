package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Date: 2019-01-03
 * Title: To Lower Case
 * Url: https://leetcode.com/problems/to-lower-case/
 * Description:
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 * <p>
 * Example:
 * Input: "Hello"
 * Output: "hello"
 * <p>
 * Input: "here"
 * Output: "here"
 * <p>
 * Input: "LOVELY"
 * Output: "lovely"
 */
public class _709_ToLowerCase {

    public static String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        int diff = 'A' - 'a';
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c >= 'A' && c <= 'Z') {
                chars[i] = (char) (c - diff);
            }
        }
        return new String(chars);
    }

    @Test
    public void test() {
        assertEquals("hello", toLowerCase("Hello"));
        assertEquals("here", toLowerCase("here"));
        assertEquals("lovely", toLowerCase("LOVELY"));
    }

}
