/**
 * Created by Nikhil on 11/2/16.
 * <p>
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 */

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 */

/**
 * Solution
 * https://discuss.leetcode.com/topic/6112/a-concise-solution-with-proof-in-the-comment/2
 */
public class FindMinimumInRotatedArray {
    public static void main(String[] args) {
        int[] input = {3, 1, 2};
        new FindMinimumInRotatedArray().findMin(input);
    }

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low < high) {
            mid = low + ((high - low) >> 1);
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else if (nums[mid] < nums[high]) {
                high = mid;
            }

        }
        return nums[low];
    }
}
