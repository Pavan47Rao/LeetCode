/**
 * You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 

Example 1:


Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.
 */

package Medium;

public class RottingOranges {
    public boolean rottenCheck(int[][] grid, int timestamp) {
        boolean toBeContinued = false;
        int[][] neighbors = {{1,0},{0,1},{-1,0},{0,-1}}; 
        int noOfRows = grid.length;
        int noOfCols = grid[0].length;
        for(int i=0;i<noOfRows;i++) {
            for(int j=0;j<noOfCols;j++) {
                if(grid[i][j] == timestamp) {
                    for(int[] neighbor: neighbors) {
                        int nrow = i+neighbor[0];
                        int ncol = j+neighbor[1];
                        if(nrow>=0 && nrow<noOfRows && ncol>=0 && ncol<noOfCols) {
                            if(grid[nrow][ncol] == 1) {
                                grid[nrow][ncol] = timestamp+1;
                                toBeContinued = true;
                            }
                        }
                    }
                }
            }
        }
        return toBeContinued;
    }
    
    public int orangesRotting(int[][] grid) {
        int timestamp = 2;
        while(rottenCheck(grid, timestamp))
            timestamp++;
        for(int[] row: grid)
            for(int cell: row)
                if(cell == 1)
                    return -1;        
        return timestamp-2;
    }
}
