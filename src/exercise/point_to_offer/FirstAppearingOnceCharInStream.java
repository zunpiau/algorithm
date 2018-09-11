package exercise.point_to_offer;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class FirstAppearingOnceCharInStream {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertEquals('#', solution.FirstAppearingOnce());
        solution.Insert('g');
        assertEquals('g', solution.FirstAppearingOnce());
        solution.Insert('o');
        assertEquals('g', solution.FirstAppearingOnce());
        solution.Insert('o');
        assertEquals('g', solution.FirstAppearingOnce());
        solution.Insert('g');
        assertEquals('#', solution.FirstAppearingOnce());
        solution.Insert('l');
        assertEquals('l', solution.FirstAppearingOnce());
        solution.Insert('e');
        assertEquals('l', solution.FirstAppearingOnce());
    }

    public class Solution {

        private LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

        //Insert one char from stringstream
        public void Insert(char ch) {
            if (!map.containsKey(ch))
                map.put(ch, 1);
            else
                map.put(ch, map.get(ch) + 1);
        }

        //return the first appearence once char in current stringstream
        public char FirstAppearingOnce() {
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1)
                    return entry.getKey();
            }
            return '#';
        }
    }

}
