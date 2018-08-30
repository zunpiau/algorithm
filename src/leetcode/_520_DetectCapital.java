package leetcode;

public class _520_DetectCapital {

    public boolean detectCapitalUse(String word) {
        return word.matches("[A-Z][a-z]+|[A-Z]+|[a-z]+");
    }

}
