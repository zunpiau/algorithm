package leetcode;

public class _392_IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        for (int i = 0, index = 0; i < s.length(); i++, index++)
            if ((index = t.indexOf(s.charAt(i), index)) == -1)
                return false;
        return true;
    }

}
