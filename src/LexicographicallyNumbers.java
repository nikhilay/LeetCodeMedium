/**
 * Created by Nikhil on 11/2/16.
 */

import java.util.LinkedList;
import java.util.List;

/**
 * Given an integer n, return 1 - n in lexicographical order.
 * For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
 * Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
 */
public class LexicographicallyNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 1; i <= 9 && i <= n; i++) {
            result.add(i);
            solve(result, i * 10, n);
        }
        return result;
    }

    private void solve(List<Integer> result, int curr, int n) {
        if (curr > n) return;
        for (int j = 0; j <= 9; j++) {
            int temp = curr + j;
            if (temp > n) return;
            result.add(temp);
            solve(result, temp * 10, n);
        }
    }
}
