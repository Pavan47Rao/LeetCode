/**
 * Given an array of integers A, a move consists of choosing any A[i], and incrementing it by 1.

Return the least number of moves to make every value in A unique.

 

Example 1:

Input: [1,2,2]
Output: 1
Explanation:  After 1 move, the array could be [1, 2, 3].
Example 2:

Input: [3,2,1,2,1,7]
Output: 6
Explanation:  After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
It can be shown with 5 or less moves that it is impossible for the array to have all unique values.
 

Note:

0 <= A.length <= 40000
0 <= A[i] < 40000

 */

package Medium;
import java.util.*;

public class MinimumIncrementToMakeArrayUnique {
    public int minIncrementForUnique(int[] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> visited = new HashSet<>();
        
        int mini = Integer.MAX_VALUE;
        for(int i: A) {
            mini = Math.min(i, mini);
            if(!visited.add(i)) {
                pq.offer(i);
            }
        }
        
        int result = 0;  
        while(!pq.isEmpty()) {
            mini++;
            if(!visited.contains(mini) && pq.peek()<mini) {
                result += mini-pq.poll();
            }
        }
        
        return result;
    }
}
