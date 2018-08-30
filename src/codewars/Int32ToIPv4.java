package codewars;

import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static org.junit.Assert.assertEquals;

public class Int32ToIPv4 {

    public static String longToIP(long ip) {
        // Java doesn't have uint32, so here we use long to represent int32
        return LongStream.of(24, 16, 8, 0)
                .map(i -> (ip >> i) & 255)
                .mapToObj(Long::toString)
                .collect(Collectors.joining("."));
    }

    @Test
    public void test() {
        assertEquals("113.82.228.186", Int32ToIPv4.longToIP(1901257914));
        assertEquals("0.0.0.0", Int32ToIPv4.longToIP(0));
    }

}
