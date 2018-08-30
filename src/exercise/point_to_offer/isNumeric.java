package exercise.point_to_offer;

import org.junit.Assert;
import org.junit.Test;

public class isNumeric {

    /*
     * Test Case:
     * "3." => true
     * "." => false
     * "e" => false
     * ".-4" => false
     * "+.8" => true
     * " -." => false
     * */
    @Test
    public void test() {
        Assert.assertTrue(isNumeric(".3"));
        Assert.assertTrue(isNumeric("+.8"));
        Assert.assertTrue(isNumeric("-1E-16"));
        Assert.assertFalse(isNumeric(".-4"));
        Assert.assertFalse(isNumeric("e"));
        Assert.assertFalse(isNumeric("."));
        Assert.assertFalse(isNumeric("-."));
        Assert.assertFalse(isNumeric("12e"));
        Assert.assertFalse(isNumeric("1a3.14"));
        Assert.assertFalse(isNumeric("1.2.3"));
        Assert.assertFalse(isNumeric("+-5"));
        Assert.assertFalse(isNumeric("12e+4.3"));
    }

    public boolean isNumeric(String str) {
        return isNumeric(str.toCharArray());
    }

    public boolean isNumeric(char[] str) {
        if (str.length == 0 || (str.length == 1 && !(str[0] >= '0' && str[0] <= '9')))
            return false;
        boolean hasDot = false, hasE = false, hasSign = false;
        int index = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'e' || str[i] == 'E') {
                if (i == str.length - 1 || index < 1 || hasE)
                    return false;
                index = 0;
                hasSign = false;
                hasDot = false;
                hasE = true;
            } else if (str[i] == '-' || str[i] == '+') {
                if (i == str.length - 1 || index != 0 || hasSign || hasDot)
                    return false;
                hasSign = true;
            } else if (str[i] == '.') {
                if (hasE || hasDot)
                    return false;
                hasDot = true;
            } else if (str[i] >= '0' && str[i] <= '9') {
                index++;
            } else {
                return false;
            }
        }
        return index != 0;
    }

}
