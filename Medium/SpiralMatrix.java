/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.

 

Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:

Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
 */

package Medium;
import java.util.*;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix.length == 0)
            return result;
        int rowBeginning = 0, columnBeginning = 0;
        int rowEnd = matrix.length - 1, columnEnd = matrix[0].length - 1;
        while(rowBeginning <= rowEnd && columnBeginning <= columnEnd) {
            for(int i=columnBeginning;i<=columnEnd;i++)
                result.add(matrix[rowBeginning][i]);
            rowBeginning++;
            for(int i=rowBeginning;i<=rowEnd;i++)
                result.add(matrix[i][columnEnd]);
            columnEnd--;
            if(rowBeginning<=rowEnd) {
                for(int i=columnEnd; i>=columnBeginning;i--)
                    result.add(matrix[rowEnd][i]);
            }
            rowEnd--;
            if(columnBeginning<=columnEnd) {
                for(int i=rowEnd; i>=rowBeginning;i--)
                    result.add(matrix[i][columnBeginning]);
            }
            columnBeginning++;
        }
        return result;
    }
}
