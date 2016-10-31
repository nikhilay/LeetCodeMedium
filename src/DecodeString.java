/**
 * Created by Nikhil on 10/30/16.
 */

/**
 * Given an encoded string, return it's decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets
 * is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * You may assume that the input string is always valid; No extra white spaces, square brackets
 * are well-formed, etc.
 * Furthermore, you may assume that the original data does not contain any digits and that
 * digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 */

import java.util.Stack;

/**
 * Solution from which below is inspired
 * https://discuss.leetcode.com/topic/57159/simple-java-solution-using-stack/3
 */

public class DecodeString {
    class StrItem{
        private StringBuilder sb;
        int n;
        StrItem(int n){
            sb = new StringBuilder();
            this.n = n;
        }
    }

    public static void main(String[] args) {
        new DecodeString().decodeString("3[a2[c]]");
    }
    public String decodeString(String s) {
        if(s.length()==0) return "";
        int num =0;
        Stack<StrItem> stack = new Stack<>();
        stack.push(new StrItem(1));
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);

            switch(c){
                case'0':case '1':case'2':case'3':case'4':case'5':case'6':case'7':case'8':case'9':
                    num = num*10 +c -'0';
                    break;
                case '[':
                    StrItem st = new StrItem(num);
                    stack.push(st);
                    num =0;
                    break;
                case ']':
                    String string = stack.peek().sb.toString();
                    int n = stack.peek().n;
                    stack.pop();
                    for(int j =0;j<n;j++){
                        stack.peek().sb.append(string);
                    }
                    break;
                default:
                        stack.peek().sb.append(c);
                    break;
            }
        }
        return stack.peek().sb.toString();
    }

}
