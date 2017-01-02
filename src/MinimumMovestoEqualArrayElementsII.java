/**
 * Created by Nikhil on 1/2/17.
 */

import java.util.Arrays;

/**
 * Given a non-empty integer array, find the minimum number of moves required to make all array elements equal,
 * where a move is incrementing a selected element by 1 or decrementing a selected element by 1.
 * You may assume the array's length is at most 10,000.
 */
public class MinimumMovestoEqualArrayElementsII {
    public int minMoves2(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        Arrays.sort(nums);
        int len = nums.length;
        int median = len/2;
        int total=0;
        for(int i=0;i<nums.length;i++){
            total+=Math.abs(nums[i]-nums[median]);
        }
        return total;

    }

}
