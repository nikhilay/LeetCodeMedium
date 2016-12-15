/**
 * Created by Nikhil on 12/14/16.
 */

import java.util.*;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 */

/**
 * Inspired from
 * https://discuss.leetcode.com/topic/20502/can-someone-please-explain-what-does-simplify-means-in-this-context
 * http://unix.stackexchange.com/questions/125522/path-syntax-rules
 * http://unix.stackexchange.com/questions/125522/path-syntax-rules
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        String[] input = path.split("/");
        HashSet<String> skip = new HashSet<>();
        Stack<String> stack = new Stack<>();
        skip.add(".");
        skip.add("");
        skip.add("..");
        StringBuilder res = new StringBuilder();
        for(String s:input){
            if(s.equals("..") && !stack.isEmpty()){
                stack.pop();
            }else if(!skip.contains(s)){
                stack.push(s);
            }
        }

        for(String s:stack){
            System.out.println(s);
            res.append("/");
            res.append(s);
        }

        return res.toString().equals("")?"/":res.toString();

    }
}
