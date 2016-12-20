/**
 * Created by Nikhil on 12/19/16.
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list,
 * find the length of shortest transformation sequence from beginWord to endWord, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the word list
 * For example,
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5
 */

/**
 * Inspired from https://discuss.leetcode.com/topic/17890/another-accepted-java-solution-bfs
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(beginWord.equals(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        queue.add(null);
        HashSet<String> visited = new HashSet<>();
        visited.add(beginWord);
        int count =1;
        while(!queue.isEmpty()){
            String str = queue.poll();
            if(str!=null){
                char[] charArr = str.toCharArray();
                for(int i=0;i<str.length();i++){
                    for(char c ='a';c<='z';c++){
                        char temp = charArr[i];
                        charArr[i]=c;
                        String s = new String(charArr);
                        if(s.equals(endWord)) return count+1;
                        if(wordList.contains(s) && !visited.contains(s)){
                            queue.add(s);
                            visited.add(s);
                        }
                        charArr[i]= temp;
                    }
                }

            }else{
                count++;
                if(!queue.isEmpty()){
                    queue.add(null);
                }

            }
        }

        return 0;
    }
}
