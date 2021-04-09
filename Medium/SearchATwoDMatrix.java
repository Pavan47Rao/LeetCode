/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
 

Example 1:

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Example 2:

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104
 */

package Medium;

public class SearchATwoDMatrix {
     //Traditional Binary Search
     private int binarySearch(int[] nums, int target){
        if(nums == null || nums.length == 0)
            return 0;
        
        int start = 0;
        int end = nums.length - 1;
        
        while(start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                end = mid-1;
            else
                start = mid+1;
        }
        
        return start;
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        
        int[] lastCol = new int[matrix.length];
        
        //Create a new array containing the last col ele
        for(int i = 0; i<lastCol.length; i++)
            lastCol[i] = matrix[i][matrix[i].length - 1]; //last element
        
        //Find Row
        int targetRow = binarySearch(lastCol, target);
        
        //Element is greater than the last row, last ele
        if(targetRow >= matrix.length)
            return false;
        
        //Find col
        int targetCol = binarySearch(matrix[targetRow], target);
        
        //Target might not be present in the matrix
        return matrix[targetRow][targetCol] == target;
    }
}

/**
 * Approach 2
 * 
 * public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = (m * n) - 1;
        if(m == 0)
            return false;
        while(left <= right) {
            int mid = (left + right)/2;
            int midElement = matrix[mid/n][mid%n];
            if(target == midElement)
                return true;
            else if(target < midElement)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return false;
    }
 */
