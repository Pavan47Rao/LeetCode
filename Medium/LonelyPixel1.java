/**
 * Given an m x n picture consisting of black 'B' and white 'W' pixels, return the number of black lonely pixels.

A black lonely pixel is a character 'B' that located at a specific position where the same row and same column don't have any other black pixels.

 

Example 1:


Input: picture = [["W","W","B"],["W","B","W"],["B","W","W"]]
Output: 3
Explanation: All the three 'B's are black lonely pixels.
Example 2:


Input: picture = [["B","B","B"],["B","B","B"],["B","B","B"]]
Output: 0
 

Constraints:

m == picture.length
n == picture[i].length
1 <= m, n <= 500
picture[i][j] is 'W' or 'B'.

 * 
 */

package Medium;

public class LonelyPixel1 {
    public int findLonelyPixel(char[][] picture) {
        int noOfRows = picture.length, noOfCols = picture[0].length, totalCount = 0;
        int[] rows = new int[noOfRows];
        int[] cols = new int[noOfCols];
        
        for(int i = 0; i < noOfRows; i++) {
            for(int j = 0; j < noOfCols; j++) {
                if(picture[i][j] == 'B') {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }
        
        for(int i = 0; i < noOfRows; i++) {
            for(int j = 0; j < noOfCols; j++) {
                if(picture[i][j] == 'B')
                    if(rows[i] == 1 && cols[j] == 1)
                        totalCount++;
            }
        }
        
        return totalCount;
    }
}
