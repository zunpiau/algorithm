package exercise.point_to_offer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FloatPower {

    @Test
    public void test() {
        assertEquals(4.0, Power(2, 2), 0);
        assertEquals(Math.pow(2.5, 0), Power(2.5, 0), 0);
        assertEquals(Math.pow(0, 5), Power(0, 5), 0);
        assertEquals(Math.pow(0.56, 5), Power(0.56, 5), 0.000000001);
        assertEquals(Math.pow(0.56, -5), Power(0.56, -5), 0.000000001);
    }

    public double Power(double base, int exponent) {
        if (base == 0) return 0;
        if (exponent == 0) return 1;
        boolean positive = exponent > 0;
        exponent = positive ? exponent : -exponent;
        double res = 1;
        while (exponent != 0) {
            if ((exponent & 1) == 1) {
                res *= base;
            }
            base *= base;
            exponent >>= 1;
        }
        return positive ? res : 1 / res;
    }
}
