/**
 * Created by Nikhil on 10/25/16.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * Different from the previous question where weight is increasing from root to leaf, now the weight is defined
 * from bottom up. i.e.,
 * the leaf level integers have weight 1, and the root level integers have the largest weight.
 * Example 1:
 * Given the list [[1,1],2,[1,1]], return 8. (four 1's at depth 1, one 2 at depth 2)
 */

public class NestedListWeightSumTwo {

    static class NestedInteger {
        private Integer number;
        private LinkedList<NestedInteger> list;

        //dummy
        private boolean isInteger() {
            return true;
        }

        private int getInteger() {
            return 1;
        }

        private LinkedList<NestedInteger> getList() {
            return new LinkedList<>();
        }
    }

    public int depthSumInverse(List<NestedInteger> nestedList) {
        return helper(nestedList, 0);
    }

    private int helper(List<NestedInteger> nestedList, int prev) {
        int curr = prev;
        List<NestedInteger> list = new LinkedList<>();
        for (NestedInteger n : nestedList) {
            if (n.isInteger()) {
                curr += n.getInteger();
            } else {
                list.addAll(n.getList());
            }
        }
        int listSum = 0;

        if (!list.isEmpty()) {
            listSum = helper(list, curr);
        }
        return listSum + curr;
    }


}
