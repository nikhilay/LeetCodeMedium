import java.util.HashSet;

/**
 * Created by Nikhil on 11/26/16.
 */

/**
 * Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.g
 * Example 1:
 * Given points = [[1,1],[-1,1]], return true.
 * Example 2:
 * Given points = [[1,1],[-1,-1]], return false.
 */
public class LineReflection {
    public boolean isReflected(int[][] points) {
        HashSet<String> hset = new HashSet<String>();
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            min = Math.min(min, x);
            max = Math.max(max, x);
            hset.add(x + "a" + y);

        }
        sum = (min + max);
        for (int[] point : points) {
            /**     (3,1) (4,1) (5,1) (6,1) (7,1)
             *  sum = 5
             *  min = 3
             *  max = 7
             *  to get 6 , we subtract 5-4(difference) + sum to get 6
             *  we will get problems if we use int
             *  so logic is(sum / 2) - point[0] + sum / 2
             */
            int x = sum - point[0];
            if (!hset.contains(x + "a" + point[1])) {
                return false;
            }
        }
        return true;
    }
}
