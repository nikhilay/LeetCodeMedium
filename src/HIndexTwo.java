/**
 * Created by Nikhil on 11/14/16.
 */

/**
 * Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?
 */
public class HIndexTwo {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int low = 0;
        int high = len - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (citations[mid] == (len - mid)) {
                return len - mid;
            } else if (citations[mid] < (len - mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return len - low;
    }
}
