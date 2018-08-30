package exercise.the_art_of_programming;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IsPalindrome {

    public static boolean middleToSides(String s) {
        for (int left = s.length() / 2 - 1, right = s.length() / 2 + s.length() % 2;
             left >= 0 && right < s.length();
             left--, right++) {
            if (s.charAt(left) != s.charAt(right))
                return false;
        }
        return true;
    }

    public static boolean sidesToMiddle(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }

    @Test
    public void test() {
        assertTrue(IsPalindrome.middleToSides("a"));
        assertTrue(IsPalindrome.middleToSides("abba"));
        assertTrue(IsPalindrome.middleToSides("abcba"));
        assertTrue(IsPalindrome.sidesToMiddle("abba"));
        assertTrue(IsPalindrome.sidesToMiddle("abcba"));

        assertFalse(IsPalindrome.middleToSides("abbc"));
        assertFalse(IsPalindrome.middleToSides("abcca"));
        assertFalse(IsPalindrome.sidesToMiddle("abbc"));
        assertFalse(IsPalindrome.sidesToMiddle("abcca"));
    }

}
