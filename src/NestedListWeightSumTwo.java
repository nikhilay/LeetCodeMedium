/**
 * Created by Nikhil on 10/25/16.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

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

    static class NestedList {
        private Integer number;
        private LinkedList<NestedList> list;
    }

    public static void main(String[] args) {
        LinkedList<NestedList> input = new LinkedList<>();
        NestedList obj1 = new NestedList();
        obj1.number =2;
        input.add(obj1);

        NestedList obj2 = new NestedList();
        obj2.number =1;


        LinkedList<NestedList> sampleList = new LinkedList<>();
        sampleList.add(obj2);
        sampleList.add(obj2);
        NestedList obj3 = new NestedList();
        obj3.list =sampleList;
        input.add(obj3);

        NestedList obj4 = new NestedList();
        obj4.list =sampleList;
        input.add(obj4);

        new NestedListWeightSumTwo().depthSumInverse(input);
    }
    public int depthSumInverse(LinkedList<NestedList> nestedList) {
        HashMap<Integer, ArrayList<Integer>> hmap = new HashMap<>();
        depthRecursive(hmap,nestedList,1);
        int sizeOfHashMap = hmap.size();
        int actualDepth = sizeOfHashMap;
        System.out.println(sizeOfHashMap);
        int sum = 0;
        for (int i = 1; i <= sizeOfHashMap; i++) {
            for (int numbers : hmap.get(i)) {
                sum += actualDepth * numbers;
            }
            actualDepth--;
        }
        System.out.println(sum);
        return sum;
    }

    private void depthRecursive(HashMap<Integer, ArrayList<Integer>> hmap, LinkedList<NestedList> nestedList, int depth) {

        for (int i = 0; i < nestedList.size(); i++) {
            if (nestedList.get(i).number != null) {
                int number = nestedList.get(i).number;
                if (hmap.containsKey(depth)) {
                    hmap.get(depth).add(number);
                } else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(number);
                    hmap.put(depth, list);
                }
            } else {
                depthRecursive(hmap, nestedList.get(i).list, depth + 1);
            }
        }
    }
}
