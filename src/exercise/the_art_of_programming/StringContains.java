package exercise.the_art_of_programming;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringContains {

    public static boolean sortContains(String a, String b) {
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        Arrays.sort(charsA);
        Arrays.sort(charsB);
        for (int ib = 0, ia = 0; ib < charsB.length; ib++) {
            while (ia < charsA.length && charsA[ia] < charsB[ib]) {
                ia++;
            }
            if (ia >= charsA.length || charsA[ia] > charsB[ib])
                return false;
        }
        return true;
    }

    public static boolean hashContains(String a, String b) {
        Map<Character, Boolean> map = new HashMap<>(26);
        for (int i = 0; i < a.length(); i++) {
            map.put(a.charAt(i), true);
        }
        for (int i = 0; i < b.length(); i++) {
            if (!map.getOrDefault(b.charAt(i), false))
                return false;
        }
        return true;
    }

    public static boolean arrayContains(String a, String b) {
        boolean[] booleans = new boolean[26];
        for (int i = 0; i < a.length(); i++) {
            booleans[a.charAt(i) - 'a'] = true;
        }
        for (int i = 0; i < b.length(); i++) {
            if (!booleans[b.charAt(i) - 'a'])
                return false;
        }
        return true;
    }

    public static boolean bitContains(String a, String b) {
        int hash = 0;
        for (int i = 0; i < a.length(); i++) {
            hash |= 1 << (a.charAt(i) - 'a');
        }
        for (int i = 0; i < b.length(); i++) {
            if ((hash & (1 << (b.charAt(i) - 'a'))) == 0)
                return false;
        }
        return true;
    }

    @Test
    public void test() {
        assertTrue(StringContains.hashContains("abcd", "abd"));
        assertTrue(StringContains.arrayContains("abcd", "abd"));
        assertTrue(StringContains.bitContains("abcd", "abd"));
        assertTrue(StringContains.sortContains("abcd", "abd"));

        assertFalse(StringContains.hashContains("abcd", "abe"));
        assertFalse(StringContains.arrayContains("abcd", "abe"));
        assertFalse(StringContains.bitContains("abcd", "abe"));
        assertFalse(StringContains.sortContains("abde", "abc"));
    }

}
