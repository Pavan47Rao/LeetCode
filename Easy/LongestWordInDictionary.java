/**
Given an array of strings words representing an English Dictionary, return the longest word in words that can be built one character at a time by other words in words.

If there is more than one possible answer, return the longest word with the smallest lexicographical order. If there is no answer, return the empty string.

 

Example 1:

Input: words = ["w","wo","wor","worl","world"]
Output: "world"
Explanation: The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
Example 2:

Input: words = ["a","banana","app","appl","ap","apply","apple"]
Output: "apple"
Explanation: Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
 

Constraints:

1 <= words.length <= 1000
1 <= words[i].length <= 30
words[i] consists of lowercase English letters.

 */

package Easy;
import java.util.*;

class Node {
    char ch;
    int end;
    Map<Character, Node> children = new HashMap<>();
    public Node(char ch) {
        this.ch = ch;
    }
}

class Trie {
    Node root;
    String[] words;
    public Trie() {
        root = new Node('0');
    }

    public void insert(String word, int index) {
        Node cur = root;
        for(char ch: word.toCharArray()) {
            cur.children.putIfAbsent(ch, new Node(ch));
            cur = cur.children.get(ch);
        }
        cur.end = index;
    }

    public String dfs() {
        Stack<Node> stack = new Stack();
        stack.push(root);
        String ans = "";
        while(!stack.isEmtpy()) {
            Node node = stack.pop();
            if(node == root || node.end > 0) {
                if(node != root) {
                    String word = words[node.end-1];
                    if(word.length() > ans.length() || word.length() == ans.length() && word.compareTo(ans < 0))
                        ans = word;
                }
                for(Node nei: node.children.values())
                    stack.push(node);
            }
        }
        return result;
    }
}

public class LongestWordInDictionary {
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        int index = 0;
        for(String word: words)
            trie.insert(word, ++index);
        trie.words = words;
        return trie.dfs();
    }
}