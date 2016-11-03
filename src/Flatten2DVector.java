/**
 * Created by Nikhil on 11/2/16.
 */

import java.util.List;

/**
 * Implement an iterator to flatten a 2d vector.
 * For example,
 * Given 2d vector =
 * [
 * [1,2],
 * [3],
 * [4,5,6]
 * ]
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].
 */

/**
 * Solution
 * https://discuss.leetcode.com/topic/30277/java-solution-beats-60-10F
 */
public class Flatten2DVector {

    private int indexList;
    private int indexElement;
    private List<List<Integer>> vec;

    Flatten2DVector(List<List<Integer>> vec2d) {
        indexList = 0;
        indexElement = 0;
        vec = vec2d;

    }

    public int next() {
        return vec.get(indexList).get(indexElement);

    }

    public boolean hasNext() {
        while (indexList < vec.size()) {
            if (indexElement < vec.get(indexList).size()) {
                return true;
            } else {
                indexList++;
                indexElement = 0;
            }

        }
        return false;
    }
}
