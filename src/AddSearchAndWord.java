/**
 * Created by Nikhil on 12/18/16.
 */

/**
 * Design a data structure that supports the following two operations:
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z
 * or .. A . means it can represent any one letter.
 * For example:
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 */

/**
 * Inspired from https://discuss.leetcode.com/topic/14030/my-simple-and-clean-java-code/2
 */
public class AddSearchAndWord {

    class TrieNode {
        TrieNode[] children;
        boolean endOfWord;

        TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;

    AddSearchAndWord(){
        root = new TrieNode();
    }



    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode current = root;
        for(int i =0;i<word.length();i++){
            char c = word.charAt(i);
            TrieNode node = current.children[c-'a'];
            if(node==null){
                node = new TrieNode();
                current.children[c-'a'] = node;
            }
            current = current.children[c-'a'];
        }
        current.endOfWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return match(word,0,root);
    }
    private boolean match(String word, int index,TrieNode node){
        if(index==word.length()) return node.endOfWord;
        char c = word.charAt(index);
        if(c!='.'){
            return node.children[c-'a']!=null&&match(word,index+1,node.children[c-'a']);
        }else{
            for(int i = 0;i<node.children.length;i++){
                if(node.children[i]!=null){
                    if(match(word,index+1,node.children[i])){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
