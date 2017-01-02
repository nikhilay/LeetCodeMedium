/**
 * Created by Nikhil on 1/2/17.
 */

import java.util.LinkedList;
import java.util.List;

/**
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements that appear twice in this array.
 * Could you do it without extra space and in O(n) runtime?
 */
public class FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        if (nums == null || nums.length == 0) return list;

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                list.add(index + 1);
            } else {
                nums[index] = -nums[index];
            }


        }
        return list;
    }
}
