/**
 * Created by Nikhil on 11/12/16.
 */

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 */
public class SortColors {

    //Solution one which beats 53.47 % of other java Solutions.
    public void sortColors(int[] nums) {
        int noOfZeros = 0;
        int noOfOnes = 0;

        for (int i : nums) {
            if (i == 0) {
                noOfZeros++;
            } else if (i == 1) {
                noOfOnes++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (noOfZeros > 0) {
                nums[i] = 0;
                noOfZeros--;

            } else if (noOfOnes > 0) {
                nums[i] = 1;
                noOfOnes--;

            } else {
                nums[i] = 2;
            }
        }
    }

}
