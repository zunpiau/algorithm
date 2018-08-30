package leetcode;

public class _680_ValidPalindromeII {

    public static void main(String[] args) {
        System.out.println(new _680_ValidPalindromeII().validPalindrome("hbakab"));
    }

    public boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; j > i; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int i, int j) {
        for (; j > i; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

}
