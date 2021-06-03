/**
Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.

 

Example 1:


Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,4,7,5,3,6,8,9]
Example 2:

Input: mat = [[1,2],[3,4]]
Output: [1,2,3,4]
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
-105 <= mat[i][j] <= 105
 */

package Medium;

public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] mat) {
        if(mat == null || mat.length == 0)
            return new int[0];
        int M = mat.length, N = mat[0].length, i = 0, j = 0, k = 1;
        int[] result = new int[M*N];
        result[0] = mat[0][0];
        while(k < M*N) {
            //move up left
            while(i >= 1 && j < N-1) {
                i--;
                j++;
                result[k++] = mat[i][j];
            }
            //move right
            if(j < N-1) {
                j++;
                result[k++] = mat[i][j];
            }
            //move down
            else if(i < M-1) {
                i++;
                result[k++] = mat[i][j];
            }
            
            //move down left
            while(i < M-1 && j >= 1) {
                i++;
                j--;
                result[k++] = mat[i][j];
            }
            //move down
            if(i < M-1) {
                i++;
                result[k++] = mat[i][j];
            }
            //move right
            else if(j < N-1) {
                j++;
                result[k++] = mat[i][j];
            }
        }
        return result;
    }
}