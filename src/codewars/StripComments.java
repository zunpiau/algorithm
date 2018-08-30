package codewars;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class StripComments {

    public static String stripComments(String text, String[] commentSymbols) {
        if (commentSymbols.length != 0) {
            String s = Arrays.stream(commentSymbols).collect(Collectors.joining("|"));
            text = text.replaceAll("[" + s + "].*", "");
        }
        return text.replaceAll(" +(\n|$)", "$1");
    }

    @Test
    public void stripComments() {
        assertEquals("a\n\n\n b\nc", StripComments.stripComments("a \n\n \n b \nc ", new String[]{}));

        assertEquals("apples, pears\ngrapes\nbananas",
                StripComments.stripComments("apples, pears # and bananas\ngrapes\nbananas !apples", new String[]{"#", "!"}));
        assertEquals("a\nc\nd", StripComments.stripComments("a #b\nc\nd $e f g", new String[]{"#", "$"}));
    }

}
