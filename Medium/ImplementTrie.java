/**
A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 

Example 1:

Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True
 

Constraints:

1 <= word.length, prefix.length <= 2000
word and prefix consist only of lowercase English letters.
At most 3 * 104 calls in total will be made to insert, search, and startsWith.
 */

class TrieNode {
    private char ch;
    private boolean isEnd;
    private final int R = 26;
    private TrieNode[] links;
    
    public TrieNode() {
        links = new TrieNode[R];
    }
    
    public boolean isTheEnd() {
        return this.isEnd;
    }
    
    public void setEnd() {
        this.isEnd = true;
    }
    
    public boolean containsKey(char ch) {
        return links[ch-'a'] != null;
    }
    
    public TrieNode get(char ch) {
        return links[ch-'a'];
    }
    
    public void put(char ch, TrieNode node) {
        links[ch-'a'] = node;
    }
    
}

public class ImplementTrie {
    private TrieNode root;
    /** Initialize your data structure here. */
    public ImplementTrie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for(char ch: word.toCharArray()) {
            if(!cur.containsKey(ch)) {
                cur.put(ch, new TrieNode());
            }
            cur = cur.get(ch);
        }
        cur.setEnd();
    }
    
    
    public TrieNode searchPrefix(String word) {
        TrieNode cur = root;
        for(char ch: word.toCharArray()) {
            if(cur.containsKey(ch))
                cur = cur.get(ch);
            else
                return null;
        }
        return cur;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isTheEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}