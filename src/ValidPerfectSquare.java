/**
 * Created by Nikhil on 11/10/16.
 */

/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * Note: Do not use any built-in library function such as sqrt.
 */

public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {

        int low = 1;
        int high = num;

        while (low <= high) {
            long mid = low + ((high - low) >> 1);
            if ((mid * mid) == num) {
                return true;
            } else if ((mid * mid) > num) {
                high = (int) mid - 1;
            } else {
                low = (int) mid + 1;
            }
        }
        return false;
    }
}
