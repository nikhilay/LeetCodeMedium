/**
 * Created by Nikhil on 11/11/16.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * Find all strobogrammatic numbers that are of length = n.
 * For example,
 * Given n = 2, return ["11","69","88","96"].
 * n = 1:   0, 1, 8
 * n = 2:   11, 69, 88, 96
 * n = 3:   101, 609, 808, 906, 111, 619, 818, 916, 181, 689, 888, 986
 * n = 4:   1001, 6009, 8008, 9006, 1111, 6119, 8118, 9116, 1691, 6699, 8698, 9696, 1881, 6889, 8888, 9886,
 * 1961, 6969, 8968, 9966
 */

/**
 * Inspired from https://discuss.leetcode.com/topic/20753/ac-clean-java-solutionS
 */
public class StrobogrammaticNumberTwo {

    public static void main(String[] args) {
        List<String> result = new StrobogrammaticNumberTwo().findStrobogrammatic(3);
        for(String s:result){
            System.out.print(s+", ");
        }
    }

    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }

    private List<String> helper(int n, int targetLength) {

        if (n == 0) return new ArrayList<>(Arrays.asList(""));
        if (n == 1) return new ArrayList<>(Arrays.asList("0", "1", "8"));

        List<String> list = helper(n - 2, targetLength);
        List<String> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);

            if (n != targetLength) {
                result.add("0" + s + "0");
            }
            result.add("1" + s + "1");
            result.add("6" + s + "9");
            result.add("8" + s + "8");
            result.add("9" + s + "6");
        }

        return result;
    }


}
