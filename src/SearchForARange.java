/**
 * Created by Nikhil on 11/21/16.
 */

/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 */
public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums == null || nums.length == 0) return result;
        int low = 0;
        int high = nums.length - 1;
        result[0] = nums.length;
        searchRange(nums, target, low, high, result);
        if (result[0] > result[1]) result[0] = -1;
        return result;
    }

    private void searchRange(int[] nums, int target, int low, int high, int[] range) {
        if (low > high) return;
        int mid = low + (high - low) / 2;

        if (nums[mid] == target) {
            if (mid < range[0]) {
                range[0] = mid;
                searchRange(nums, target, low, mid - 1, range);
            }

            if (mid > range[1]) {
                range[1] = mid;
                searchRange(nums, target, mid + 1, high, range);
            }

        } else if (nums[mid] < target) {
            searchRange(nums, target, mid + 1, high, range);
        } else {
            searchRange(nums, target, low, mid - 1, range);
        }

    }
}
