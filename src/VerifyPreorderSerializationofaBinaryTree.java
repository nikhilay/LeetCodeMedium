/**
 * Created by Nikhil on 11/18/16.
 */

/**
 * One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node,
 * we record the node's value. If it is a null node, we record using a sentinel value such as #.
 * _9_
 * /   \
 * 3     2
 * / \   / \
 * 4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where #
 * represents a null node.
 * Given a string of comma separated values, verify whether it is a correct preorder traversal serialization
 * of a binary tree. Find an algorithm without reconstructing the tree.
 * Each comma separated value in the string must be either an integer or a character '#' representing null pointer.
 * You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".
 */
public class VerifyPreorderSerializationofaBinaryTree {
    public static void main(String[] args) {
        new VerifyPreorderSerializationofaBinaryTree().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
    }

    public boolean isValidSerialization(String preorder) {
        int nonLeaves = 0;
        int leaves = 0;
        int i = 0;
        String[] input = preorder.split(",");
        for (i = 0; i < input.length && leaves != nonLeaves + 1; i++) {
            if (input[i].equals("#")) {
                leaves++;
            } else {
                nonLeaves++;
            }
        }
        return leaves == nonLeaves + 1 && i == input.length;
    }
}
