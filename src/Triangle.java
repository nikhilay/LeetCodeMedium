/**
 * Created by Nikhil on 11/13/16.
 */

import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 * For example, given the following triangle
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size()-2; i >=0 ; i--) {
            List<Integer> current = triangle.get(i);
            List<Integer> next = triangle.get(i + 1);
            for (int j = 0; j < current.size(); j++) {
                int value1 = current.get(j) + next.get(j);
                int value2 = current.get(j) + next.get(j + 1);
                current.set(j, Math.min(value1, value2));

            }
        }
        return triangle.get(0).get(0);
    }

}
