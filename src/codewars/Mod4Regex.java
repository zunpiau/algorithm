package codewars;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class Mod4Regex {

    public static Pattern mod4 = Pattern.compile(
            "\\[[-+]?((2|6|([15937])+([048]))*(0|4|8|([15937])+([26])))+]");

    @Test
    public void testNumber() {
        for (int i = 0; i < 100000; i++) {
            assertEquals(i % 4 == 0, Mod4Regex.mod4.matcher("[" + i + "]").find());
        }
    }

    @Test
    public void testValidMod4() {
        String[] validTests = {"[+05620]", "[005624]", "[-05628]", "[005632]", "[555636]", "[+05640]", "[005600]",
                "the beginning [-0] the end", "~[4]", "[32]", "the beginning [0] ... [invalid] numb[3]rs ... the end",
                "...may be [+002016] will be."};
        for (String test : validTests) {
            Matcher m = Mod4Regex.mod4.matcher(test);
            assertTrue(test + " is valid, but no match was made.", m.find());
        }
    }

    @Test
    public void testInvalidMod4() {
        String[] invalidTests = {"[+05621]", "[-55622]", "[005623]", "[~24]", "[8.04]", "No, [2014] isn't a multiple of 4..."};
        for (String test : invalidTests) {
            Matcher m = Mod4Regex.mod4.matcher(test);
            assertFalse(test + " is invalid, but a match was made.", m.find());
        }
    }

}
