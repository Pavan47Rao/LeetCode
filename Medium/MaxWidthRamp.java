/**
 * Given an array A of integers, a ramp is a tuple (i, j) for which i < j and A[i] <= A[j].  The width of such a ramp is j - i.

Find the maximum width of a ramp in A.  If one doesn't exist, return 0.

 

Example 1:

Input: [6,0,8,2,1,5]
Output: 4
Explanation: 
The maximum width ramp is achieved at (i, j) = (1, 5): A[1] = 0 and A[5] = 5.
Example 2:

Input: [9,8,1,0,1,9,4,0,4,1]
Output: 7
Explanation: 
The maximum width ramp is achieved at (i, j) = (2, 9): A[2] = 1 and A[9] = 1.
 

Note:

2 <= A.length <= 50000
0 <= A[i] <= 50000
 */

package Medium;
import java.util.*;

public class MaxWidthRamp {
    class Number {
        int number;
        int indexOfNo;
        Number(int no, int ind){
            number = no;
            indexOfNo = ind;
        }
    }
    
    public int maxWidthRamp(int[] A) {
        if(A == null || A.length <= 1) 
            return 0;
        
        Stack<Number> s = new Stack<>();
        s.push(new Number(A[A.length-1], A.length-1));
        
        for(int i = A.length-2; i>=0; i--) {
            if(A[i] > s.peek().number) {
                s.push(new Number(A[i], i));
            }
        }
        
        int i=0, max=0;
        while(!s.isEmpty() && i < A.length) {
            while(!s.isEmpty() && A[i] <= s.peek().number) {
                Number popped = s.pop();
                max = Math.max(max, popped.indexOfNo-i);
            }
            i++;
        }
        
        return max;
    }
}
