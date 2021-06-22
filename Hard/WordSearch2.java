/**
 * Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 

Example 1:


Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]
Example 2:


Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []
 

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 12
board[i][j] is a lowercase English letter.
1 <= words.length <= 3 * 104
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
All the strings of words are unique.

 */

package Hard;
import java.util.*;

class TrieNode {
    String word = null;
    Map<Character, TrieNode> children = new HashMap<>();
    public TrieNode() {}
}

public class WordSearch2 {
    char[][] _board = null;
    List<String> result = new ArrayList<>();
    
    public List<String> findWords(char[][] board, String[] words) {
        
        TrieNode root = new TrieNode();
        for(String word: words) {
            TrieNode node = root;
            for(char ch: word.toCharArray()) {
                node.children.putIfAbsent(ch, new TrieNode());
                node = node.children.get(ch);
            }
            node.word = word;
        }
        
        this._board = board;
        
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[0].length; col++) {
                if(root.children.containsKey(board[row][col]))
                    backtracking(row, col, root);
            }
        }
        
        return this.result;
        
    }
    
    public void backtracking(int row, int col, TrieNode parent) {
        Character letter = this._board[row][col];
        TrieNode curNode = parent.children.get(letter);
        
        if(curNode.word != null) {
            this.result.add(curNode.word);
            curNode.word = null;
        }
        
        this._board[row][col] = '#';
        
        int[] rowOffSet = {0, 0, 1, -1};
        int[] colOffSet = {1, -1, 0, 0};
        
        for(int i = 0; i < 4; i++) {
            int newRow = row + rowOffSet[i];
            int newCol = col + colOffSet[i];
            if(newRow < 0 || newRow >= this._board.length || newCol < 0 || newCol >= this._board[0].length)
                continue;
            if(curNode.children.containsKey(this._board[newRow][newCol]))
                backtracking(newRow, newCol, curNode);
        }
        
        this._board[row][col] = letter;
        
        if(curNode.children.isEmpty())
            parent.children.remove(letter);
    }
}
