package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by haodongl on 3/5/16.
 */
public class WordDictionary {

    public static void main(String[] args){
        WordDictionary test = new WordDictionary();
        test.addWord("dad");
        test.addWord("mad");
        test.addWord("bad");
        System.out.println(test.search("b.."));
    }

    class TrieNode{
        public TrieNode(char value, boolean isLeaf){
            this.value = value;
            this.isLeaf = isLeaf;
        }
        public Map<Character, TrieNode> children = new HashMap<>();
        public char value;
        public boolean isLeaf;
    }

    TrieNode root = new TrieNode('\0', false);

    // Adds a word into the data structure.
    public void addWord(String word) {
        if(word == null) return;
        TrieNode current = root;
        for(int i=0; i<word.length(); i++){
            char tmp = word.charAt(i);
            if(current.children.containsKey(tmp)){
                current = current.children.get(tmp);
            }else {
                if(i == word.length() - 1){
                    TrieNode node = new TrieNode(tmp, true);
                    current.children.put(tmp, node);
                    current = node;
                }else {
                    TrieNode node = new TrieNode(tmp, false);
                    current.children.put(tmp,node);
                    current = node;
                }
            }
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return dfsUtil(root, word, 0);
    }

    private boolean dfsUtil(TrieNode root, String word, int start){
        if(word.charAt(start) == '.'){
            if(start == word.length() -1){
                for(TrieNode node : root.children.values()){
                    if(node.isLeaf) return true;
                }
                return false;
            }else {
                for(TrieNode node : root.children.values()){
                    if(dfsUtil(node, word, start+1)){
                        return true;
                    }
                }
                return false;
            }
        }else {
            if(start == word.length() - 1){
                return root.children.containsKey(word.charAt(start)) && root.children.get(word.charAt(start)).isLeaf;
            }else {
                if(root.children.containsKey(word.charAt(start))) return dfsUtil(root.children.get(word.charAt(start)), word, start +1);
                else return false;
            }
        }
    }
}
