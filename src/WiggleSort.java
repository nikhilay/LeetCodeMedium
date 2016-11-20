
/**
 * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
 * For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
 */

public class WiggleSort {

    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int k = 0;
        while (k < nums.length - 1 && nums[k + 1] == nums[k]) {
            k++;
        }
        if (k == nums.length - 1) return 1;
        int result = 2;
        boolean small = nums[k] < nums[k + 1];
        for (int i = k + 1; i < nums.length - 1; i++) {

            if (small && nums[i + 1] < nums[i]) {
                nums[result] = nums[i + 1];
                result++;
                small = !small;
            } else if (!small && nums[i + 1] > nums[i]) {
                nums[result] = nums[i + 1];
                result++;
                small = !small;
            }

        }

        return result;
    }

}
