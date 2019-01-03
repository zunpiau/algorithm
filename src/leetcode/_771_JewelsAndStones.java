package leetcode;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Date: 2018-12-26
 * Title: Jewels and Stones
 * Url: https://leetcode.com/problems/jewels-and-stones/
 * Description:
 * You're given strings J representing the types of stones that are jewels,
 * and S representing the stones you have.  Each character in S is a type of stone you have.
 * You want to know how many of the stones you have are also jewels.
 * <p>
 * The letters in J are guaranteed distinct, and all characters in J and S are letters.
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 * <p>
 * Example:
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * <p>
 * Input: J = "z", S = "ZZ"
 * Output: 0
 * <p>
 * Note:
 * S and J will consist of letters and have length at most 50.
 * The characters in J are distinct.
 */
public class _771_JewelsAndStones {

    public static int numJewelsInStones(String J, String S) {
        char[] jewels = J.toCharArray();
        char[] stones = S.toCharArray();
        Arrays.sort(jewels);
        Arrays.sort(stones);
        int counter = 0;
        for (int i = 0, k = 0; i < jewels.length && k < stones.length; ) {
            if (jewels[i] == stones[k]) {
                counter++;
                k++;
            } else if (jewels[i] > stones[k]) {
                k++;
            } else {
                i++;
            }
        }
        return counter;
    }

    @Test
    public void test() {
        assertEquals(2, numJewelsInStones("bcd", "abc"));
        assertEquals(2, numJewelsInStones("abc", "bcd"));
        assertEquals(0, numJewelsInStones("z", "ZZ"));
    }

}
