/**
 * Created by Nikhil on 11/17/16.
 */
public class SearchinRotatedSortedArrayTwo {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] == nums[high]) {
                high--;
            } else if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }

            }
        }
        return false;
    }
}
