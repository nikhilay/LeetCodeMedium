/**
 * Created by Nikhil on 11/2/16.
 */

/**
 * Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
 * You may assume each number in the sequence is unique.
 * Follow up:
 * Could you do it using only constant space complexity?
 */

import java.util.Stack;

/**
 * Solution inspired from
 * https://discuss.leetcode.com/topic/21217/java-o-n-and-o-1-extra-space
 */
public class VerifyPreOrderSequenceInBinaryTree {
    public boolean verifyPreorder(int[] preorder) {
        if(preorder==null || preorder.length==0) return false;
        Stack<Integer> stack = new Stack<>();
        int low = Integer.MIN_VALUE;
        for(int i=0;i<preorder.length;i++){
            if(preorder[i]<low){
                return false;
            }

            while(!stack.isEmpty() && preorder[i]>stack.peek()){
                low = stack.pop();
            }
            stack.push(preorder[i]);
        }
        return true;
    }

}
