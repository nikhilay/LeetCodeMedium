/**
 * Created by Nikhil on 1/2/17.
 */

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Now your job is to find the total Hamming distance between all pairs of the given numbers.
 */

/**
 * Inspired from
 * https://discuss.leetcode.com/topic/72092/java-o-n-time-o-1-space
 */
public class TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int total = 0;
        int n = nums.length;
        for (int i = 0; i < 32; i++) {
            int bitcount = 0;
            for (int j = 0; j < n; j++) {
                bitcount += (nums[j] >> i) & 1;
            }
            total += bitcount * (n - bitcount);
        }
        return total;
    }
}
