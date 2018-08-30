package leetcode;

public class _058_LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        String[] strings = s.split(" ");
        if (strings.length == 0)
            return 0;
        return strings[strings.length - 1].length();
    }
}