/**
 * Created by Nikhil on 11/10/16.
 */

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a nested list of integers, implement an iterator to flatten it.
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * Example 1:
 * Given the list [[1,1],2,[1,1]],
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].
 * Example 2:
 * Given the list [1,[4,[6]]],
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
 */

public class FlattenNestedListIterator {

    class NestedInteger {
        //Methods in NestedInteger are just written for the sake of not getting an error. These methods will be given by
        //leetcode and we should use those to implement next() and hasNext() method.
        public boolean isInteger() {
            return true;
        }

        public Integer getInteger() {
            return 1;
        }

        public List<NestedInteger> getList() {
            List<NestedInteger> list = new LinkedList<>();
            return list;
        }
    }

    private Queue<Integer> queue;

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        queue = new LinkedList<>();
        helper(nestedList);
    }

    private void helper(List<NestedInteger> nestedList) {
        for (int i = 0; i < nestedList.size(); i++) {
            if (nestedList.get(i).isInteger()) {
                queue.add(nestedList.get(i).getInteger());
            } else {
                helper(nestedList.get(i).getList());
            }
        }
    }


    public Integer next() {
        return queue.remove();
    }


    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
