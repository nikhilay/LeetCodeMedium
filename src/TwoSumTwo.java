/**
 * Created by Nikhil on 10/25/16.
 */

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be
 * less than index2.
 * Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */

public class TwoSumTwo {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) return null;
        int start = 0;
        int end = numbers.length - 1;
        int sum = 0;
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        while (start < end) {
            sum = numbers[start] + numbers[end];

            if (sum == target) {
                result[0] = start + 1;
                result[1] = end + 1;
                return result;
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }

        }
        return result;

    }

}
