package codewars;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BinaryRegexP {

    public static Pattern multipleOf3() {
        // Regular expression that matches binary inputs that are multiple of 3
        return Pattern.compile("(0*(1(01*0)*1)*)*");
    }

    @Test
    public void test() {
        Pattern p = BinaryRegexP.multipleOf3();
        for (int i = 0; i < 10000; i++) {
            Assert.assertEquals(String.format("%7s", Integer.toBinaryString(i)).replace(' ', '0'),
                    i % 3 == 0,
                    p.matcher(Integer.toBinaryString(i)).matches());
        }
    }

    @Test
    public void simpleTest() {
        Pattern p = BinaryRegexP.multipleOf3();
        assertFalse(p.matcher(" 0").matches());
        assertFalse(p.matcher("abc").matches());
        assertTrue(p.matcher("000").matches());
        assertTrue(p.matcher("110").matches());
        assertFalse(p.matcher("111").matches());
        assertTrue(p.matcher(Integer.toBinaryString(12345678)).matches());
    }

}
