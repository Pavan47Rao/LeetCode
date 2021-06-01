/**
Let's play the minesweeper game (Wikipedia, online game)!

You are given an m x n char matrix board representing the game board where:

'M' represents an unrevealed mine,
'E' represents an unrevealed empty square,
'B' represents a revealed blank square that has no adjacent mines (i.e., above, below, left, right, and all 4 diagonals),
digit ('1' to '8') represents how many mines are adjacent to this revealed square, and
'X' represents a revealed mine.
You are also given an integer array click where click = [clickr, clickc] represents the next click position among all the unrevealed squares ('M' or 'E').

Return the board after revealing this position according to the following rules:

If a mine 'M' is revealed, then the game is over. You should change it to 'X'.
If an empty square 'E' with no adjacent mines is revealed, then change it to a revealed blank 'B' and all of its adjacent unrevealed squares should be revealed recursively.
If an empty square 'E' with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the number of adjacent mines.
Return the board when no more squares will be revealed.
 

Example 1:


Input: board = [["E","E","E","E","E"],["E","E","M","E","E"],["E","E","E","E","E"],["E","E","E","E","E"]], click = [3,0]
Output: [["B","1","E","1","B"],["B","1","M","1","B"],["B","1","1","1","B"],["B","B","B","B","B"]]
Example 2:


Input: board = [["B","1","E","1","B"],["B","1","M","1","B"],["B","1","1","1","B"],["B","B","B","B","B"]], click = [1,2]
Output: [["B","1","E","1","B"],["B","1","X","1","B"],["B","1","1","1","B"],["B","B","B","B","B"]]
 

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 50
board[i][j] is either 'M', 'E', 'B', or a digit from '1' to '8'.
click.length == 2
0 <= clickr <= m
0 <= clickc <= n
board[clickr][clickc] is either 'M' or 'E'.
 */

package Medium;

public class MineSweeper {
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
    int m, n;
    
    public char[][] updateBoard(char[][] board, int[] click) {
        m = board.length;
        n = board[0].length;
        dfs(board, click[0], click[1]);
        return board;
    }
    
    public boolean isOutBound(int x, int y) {
        if(x < 0 || x >= m || y < 0 || y >= n)
            return true;
        return false;
    }
    
    public int numOfCell(int x, int y, char[][] board) {
        int num = 0;
        for(int[] arr: directions) {
            int i = arr[0], j = arr[1];
            if(!isOutBound(i+x, j+y) && board[i+x][j+y] == 'M')
               num++; 
        }
        return num;
    }
    
    public void dfs(char[][] board, int x, int y) {
        if(isOutBound(x, y))
            return;
        if(board[x][y] == 'M') {
            board[x][y] = 'X';
            return;
        }
        else if(board[x][y] == 'E') {
            int num = numOfCell(x, y, board);
            if(num > 0)
                board[x][y] = (char) (num + '0');
            else {
                board[x][y] = 'B';
                for(int arr[]: directions)
                    dfs(board, x + arr[0], y + arr[1]);
            }
        }
    }
}