/**
 * Created by Nikhil on 11/12/16.
 */

/**
 * There is a list of sorted integers from 1 to n. Starting from left to right,
 * remove the first number and every other number afterward until you reach the end of the list.
 * Repeat the previous step again, but this time from right to left, remove the right
 * most number and every other number from the remaining numbers.
 * We keep repeating the steps again, alternating left to right and right to left, until a single number remains.
 * Find the last number that remains starting with a list of length n.l
 */

//Inspired from https://discuss.leetcode.com/topic/59293/java-easiest-solution-o-logn-with-explanation
public class EliminationGame {

    public int lastRemaining(int n) {
        int head =1;
        int step = 1;
        int remaining = n;
        boolean left = true;
        while(remaining>1){
            if(left || (remaining%2)==1){
                head = head +step;
            }
            remaining/=2;
            step *=2;
            left = !left;
        }

        return head;
    }
}
