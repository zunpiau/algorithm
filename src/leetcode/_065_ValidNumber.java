package leetcode;

public class _065_ValidNumber {
    /*
     * Test Case:
     * "3." => true
     * "." => false
     * "e" => false
     * ".-4" => false
     * "+.8" => true
     * " -." => false
     * */

    public boolean isNumber(String s) {
        char[] chars = s.trim().toCharArray();
        if (chars.length == 0 || (chars.length == 1 && !(chars[0] >= '0' && chars[0] <= '9')))
            return false;
        boolean hasDot = false, hasE = false, hasSign = false;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'e') {
                if (i == chars.length - 1 || index < 1 || hasE)
                    return false;
                index = 0;
                hasSign = false;
                hasDot = false;
                hasE = true;
            } else if (chars[i] == '-' || chars[i] == '+') {
                if (i == chars.length - 1 || index != 0 || hasSign || hasDot)
                    return false;
                hasSign = true;
            } else if (chars[i] == '.') {
                if (hasE || hasDot)
                    return false;
                hasDot = true;
            } else if (chars[i] >= '0' && chars[i] <= '9') {
                index++;
            } else {
                return false;
            }
        }
        return index != 0;
    }
}