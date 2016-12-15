import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Nikhil on 12/15/16.
 */

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.

 For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

 Note: The result may be very large, so you need to return a string instead of an integer.
 */

/**
 * Inspired from https://discuss.leetcode.com/topic/8018/my-java-solution-to-share
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        if (nums == null || nums.length == 0) return sb.toString();
        String[] numString = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numString[i] = String.valueOf(nums[i]);
        }
        Comparator<String> cmp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1);
            }
        };
        Arrays.sort(numString, cmp);
        if(numString[0].charAt(0)=='0'){
            return "0";
        }
        for (String s : numString) {
            sb.append(s);
        }
        return sb.toString();

    }
}
