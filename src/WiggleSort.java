/**
 * Created by Nikhil on 10/24/16.
 */

import java.util.Arrays;

import static com.sun.tools.javac.jvm.ByteCodes.swap;

/**
 * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
 * For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
 */

public class WiggleSort {

    public void wiggleSortEfficient(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int a =nums[i-1];
            if((a>nums[i])==((i%2)==1)){
                nums[i-1] = nums[i];
                nums[i] = a;
            }
        }

        for(int i:nums){
            System.out.print(i+", ");
        }


    }

    //O(NlogN) way --peaks and valleys from CTCI
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 2; i < nums.length; i += 2) {
            int temp = nums[i];
            nums[i] = nums[i - 1];
            nums[i - 1] = temp;

        }
        for(int i:nums){
            System.out.print(i+", ");
        }
        System.out.println();
    }

}
