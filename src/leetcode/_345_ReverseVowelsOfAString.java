package leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class _345_ReverseVowelsOfAString {

    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) return "";
        HashSet<Character> charMap = new HashSet<>(10);
        charMap.addAll(Arrays.asList('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'));
        char[] chars = s.toCharArray();
        char preChar, postChar, t;
        for (int i = 0, j = chars.length - 1; i < j; ) {
            preChar = chars[i];
            postChar = chars[j];
            if (charMap.contains(preChar) && charMap.contains(postChar)) {
                t = preChar;
                chars[i++] = postChar;
                chars[j--] = t;
            } else if (!charMap.contains(preChar)) i++;
            else j--;
        }
        return new String(chars);
    }

}
