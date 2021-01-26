/**
 * Given an m x n board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where "adjacent" cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

Example 2:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true

Example 3:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 200
1 <= word.length <= 103
board and word consists only of lowercase and uppercase English letters.
*/

package Medium;

public class WordSearch {
    public char[][] board;
    public int ROWS;
    public int COLS;
    
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.ROWS = board.length;
        this.COLS = board[0].length;
        for(int i=0;i<this.ROWS;i++) {
            for(int j=0;j<this.COLS;j++) {
                if(this.backtrack(i,j,word,0))
                    return true;
            }
        }
        return false;
    }
    
    protected boolean backtrack(int row, int col, String word, int index) {
        if(index >= word.length())
            return true;
        if(row<0 || row==this.ROWS || col<0 || col==this.COLS || word.charAt(index)!=this.board[row][col])
            return false;
        
        this.board[row][col] = '#';
        boolean ret = false;
        
        int[] rowSet = {0,1,0,-1};
        int[] colSet = {1,0,-1,0};
        for(int i=0;i<4;i++) {
            ret = this.backtrack(row+rowSet[i], col+colSet[i], word, index+1);
            if(ret)
                break;
        }
        
        this.board[row][col] = word.charAt(index);
        return ret;
    }
}
