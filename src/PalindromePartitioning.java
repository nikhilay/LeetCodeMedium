/**
 * Created by Nikhil on 11/25/16.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * For example, given s = "aab",
 * Return
 * [
 * ["aa","b"],
 * ["a","a","b"]
 */

//Inspired from https://discuss.leetcode.com/topic/16800/concise-java-solution
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if(s.length()==0) return result;
        rec(s,result,new ArrayList<String>());
        return result;
    }

    private void rec(String s,List<List<String>> result,List<String> temp){
       if(s.length()==0){
           result.add(new ArrayList<String>(temp));
           return;
       }

       for(int i =0;i<s.length();i++){
           if(isPalindrome(s.substring(0,i+1))){
               temp.add(s.substring(0,i+1));
               rec(s.substring(i+1),result,temp);
               temp.remove(temp.size()-1);
           }
       }
    }
    private boolean isPalindrome(String s){
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}
