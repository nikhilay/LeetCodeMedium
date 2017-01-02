/**
 * Created by Nikhil on 12/18/16.
 */

/**
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the
 * difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.
 */
public class ContainsDuplicateThree {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums.length==1 ) return true;
        for (int i = 0; i <= nums.length - k; i++) {
            int j = i+k;
            while (i < j) {
                if (nums[i] - nums[j] < t) {
                    return true;
                }
                j--;
            }
        }

        return false;
    }
}
