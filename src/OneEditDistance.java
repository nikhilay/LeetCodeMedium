/**
 * Created by Nikhil on 11/26/16.
 */

/**
 * Given two strings S and T, determine if they are both one edit distance apart.
 */
public class OneEditDistance {
//DOG --> POG

    /**
     *Inspired from https://discuss.leetcode.com/topic/30308/my-clear-java-solution-with-explanation/2
     */
    public boolean isOneEditDistance(String s, String t) {

        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if(s.charAt(i)!=t.charAt(i)){
                if(s.length()==t.length()){
                    return s.substring(i+1).equals(t.substring(i+1));
                }else if(s.length()<t.length()){
                    return s.substring(i).equals(t.substring(i+1));
                }else{
                    return s.substring(i+1).equals(t.substring(i));
                }
            }
        }
        return Math.abs(s.length()- t.length())==1;
    }
}
