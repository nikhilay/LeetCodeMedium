/**
 * Created by Nikhil on 11/15/16.
 */

/**
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 */

public class Sqrt {
    public int mySqrt(int x) {
        int low = 1;
        int high = x;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid <= x / mid) {
                low = mid + 1;
                ans = mid;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
