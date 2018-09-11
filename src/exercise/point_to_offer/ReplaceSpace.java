package exercise.point_to_offer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReplaceSpace {

    @Test
    public void test() {
        assertEquals("We%20Are%20Happy", replaceSpace(new StringBuffer("We Are Happy")));
        assertEquals("We%20", replaceSpace(new StringBuffer("We ")));
        assertEquals("", replaceSpace(new StringBuffer()));
        assertEquals("%20", replaceSpace(new StringBuffer(" ")));
        assertEquals("%20%20", replaceSpace(new StringBuffer("  ")));
    }

    public String replaceSpace(StringBuffer str) {
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (c == ' ') {
                str.setCharAt(i, '%');
                str.insert(i + 1, "20");
            }
        }
        return str.toString();
    }

}
