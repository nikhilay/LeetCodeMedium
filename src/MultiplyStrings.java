/**
 * Created by Nikhil on 12/12/16.
 */
/**
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * Note:
 * The numbers can be arbitrarily large and are non-negative.
 * Converting the input string to integer is NOT allowed.
 * You should NOT use internal library such as BigInteger.
 */

/**
 * Inspired from https://discuss.leetcode.com/topic/30508/easiest-java-solution-with-graph-explanation/2
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int num1Len = num1.length();
        int num2Len = num2.length();
        int[] pos = new int[num1Len + num2Len];
        StringBuilder sb = new StringBuilder();
        for (int i = num1Len - 1; i >= 0; i--) {
            for (int j = num2Len - 1; j >= 0; j--) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = product + pos[p2];
                pos[p2] = sum % 10;
                pos[p1] += sum / 10;
            }
        }

        for (int p : pos) {
            if (!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
