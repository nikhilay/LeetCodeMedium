/**
 * Created by Nikhil on 10/25/16.
 */

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Given two 1d vectors, implement an iterator to return their elements alternately.
 * For example, given two 1d vectors:
 * v1 = [1, 2]
 * v2 = [3, 4, 5, 6]
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].
 * Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?
 * Clarification for the follow up question - Update (2015-09-18):
 * The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you,
 * replace "Zigzag" with "Cyclic". For example, given the following input:
 * [1,2,3]
 * [4,5,6,7]
 * [8,9]
 * It should return [1,4,8,2,5,9,3,6,7].
 */

public class ZigZagIterator {
    private int[] startIndexArray;
    private int[] endIndexArray;
    private boolean[] check;
    private int currentIndex;
    private LinkedList<int[]> input;

    ZigZagIterator(LinkedList<int[]> input) {
        startIndexArray = new int[input.size()];
        endIndexArray = new int[input.size()];
        check = new boolean[input.size()];
        int index = 0;
        for (int[] vector : input) {
            endIndexArray[index] = vector.length;
            index++;
        }

        Arrays.fill(check, true);
        currentIndex = 0;
        this.input = input;
    }


    public static void main(String[] args) {
        int[] input1 = {1, 2};
        int[] input2 = {3, 4, 5, 6};
        int[] input3 = {9, 10, 11};
        int[] input4 = {5, 8, 13, 15, 20};
        LinkedList<int[]> input = new LinkedList<>();
        input.add(input1);
        input.add(input2);
        input.add(input3);
        input.add(input4);
        ZigZagIterator obj = new ZigZagIterator(input);
        for (int i = 1; i <= 15; i++) {
            obj.next();
        }


    }

    public void next() {

        while (startIndexArray[currentIndex] == endIndexArray[currentIndex]) {
            currentIndex++;
            currentIndex = currentIndex % input.size();
            if (hasNext() == false) {
                System.out.println("\nNo more elements");
                return;
            }

        }
        System.out.print(input.get(currentIndex)[startIndexArray[currentIndex]] + ", ");
        startIndexArray[currentIndex]++;
        if (startIndexArray[currentIndex] == endIndexArray[currentIndex]) {
            check[currentIndex] = false;
        }
        currentIndex++;
        currentIndex = currentIndex % input.size();
    }

    public boolean hasNext() {
        for (boolean value : check) {
            if (value == true) {
                return true;
            }
        }
        return false;
    }
}
