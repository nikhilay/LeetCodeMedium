/**
 * Created by Nikhil on 10/26/16.
 */

import java.util.Arrays;
import java.util.Random;

/**
 * Shuffle a set of numbers without duplicates.
 * Example:
 * // Init an array with set 1, 2, and 3.
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 * // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
 * solution.shuffle();
 * // Resets the array back to its original configuration [1,2,3].
 * solution.reset();
 * // Returns the random shuffling of array [1,2,3].
 * solution.shuffle();
 */
public class ShuffleAnArray {

    private int[] input;
    private int[] buffer;
    private Random rn;

    ShuffleAnArray(int[] input) {
        this.input = input;
        buffer = new int[input.length];
        System.arraycopy(input, 0, buffer, 0, input.length);
        rn = new Random();
    }


    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        System.arraycopy(input, 0, buffer, 0, input.length);
        return buffer;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {

        for (int i = 0; i < buffer.length; i++) {
            int n = rn.nextInt(buffer.length);
            int temp = buffer[n];
            buffer[n] = buffer[i];
            buffer[i] = temp;
        }
        return buffer;
    }
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
}
