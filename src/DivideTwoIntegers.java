/**
 * Created by Nikhil on 12/4/16.
 */

/**
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if ((dividend == Integer.MIN_VALUE && divisor == -1) || (divisor == 0)) return Integer.MAX_VALUE;
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        int result = 0;
        long divd = Math.abs((long) dividend);
        long dvsr = Math.abs((long) divisor);
        while (divd >= dvsr) {
            long temp = dvsr;
            int multiply = 1;
            while (divd >= (temp << 1)) {
                temp <<= 1;
                multiply <<= 1;
            }
            divd -= temp;
            result += multiply;
        }

        return sign > 0 ? result : -result;
    }
}
