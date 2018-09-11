package exercise.point_to_offer;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class JoinMinNumberInArray {

    @Test
    public void test() {
        assertEquals("", PrintMinNumber(new int[]{}));
        assertEquals("1", PrintMinNumber(new int[]{1}));
        assertEquals("223", PrintMinNumber(new int[]{23, 2}));
        assertEquals("321323", PrintMinNumber(new int[]{3, 32, 321}));
    }

    public String PrintMinNumber(int[] numbers) {
        return Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((o1, o2) -> (o1 + o2).compareTo(o2 + o1))
                .collect(Collectors.joining());
    }

}
