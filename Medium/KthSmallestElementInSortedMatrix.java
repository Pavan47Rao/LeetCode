/**
 * Given an n x n matrix where each of the rows and columns are sorted in ascending order, return the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

 

Example 1:

Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
Example 2:

Input: matrix = [[-5]], k = 1
Output: -5
 

Constraints:

n == matrix.length
n == matrix[i].length
1 <= n <= 300
-109 <= matrix[i][j] <= 109
All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
1 <= k <= n2
 */

package Medium;
import java.util.*;

public class KthSmallestElementInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        int N = matrix.length;
        for(int r = 0; r < N; r++) {
            int arr [] = {matrix[r][0], r, 0};
            heap.add(arr);
        }
        int[] min = new int[3];
        int kthMin = 0;
        while(k-- > 0) {
            min = heap.poll();
            int r = min[1], c = min[2];
            kthMin = min[0];
            if(c < N-1) {
                min[0] = matrix[r][c+1];
                min[2] = c+1;
                heap.add(min);
            }
        }
        return kthMin;
    }
}
