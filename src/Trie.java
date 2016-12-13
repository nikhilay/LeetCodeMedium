/**
 * Created by Nikhil on 12/13/16.
 */
class TrieNode {
    // Initialize your data structure here.
    TrieNode[] children;
    boolean endOfWord;
    public TrieNode() {
        children = new TrieNode[26];
        endOfWord = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("a");
        obj.search("a");
        obj.startsWith("a");

    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode current = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            int index = c - 'a';
            TrieNode node = current.children[index];
            if(node==null){
                node = new TrieNode();
                current.children[index] = node;
            }
            current = node;

        }
        current.endOfWord = true;

    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode current = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            int index = c - 'a';
            TrieNode node = current.children[index];
            if(node==null){
                return false;
            }
            current = node;

        }
        return current.endOfWord;


    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            int index = c - 'a';
            TrieNode node = current.children[index];
            if(node==null){
                return false;
            }
            current = node;

        }
        return true;

    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");