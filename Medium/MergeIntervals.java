/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
 */

package Medium;
import java.util.*;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0 || intervals.length == 1)
            return intervals;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        Stack<int[]> stackOfIntervals = new Stack<>();
        stackOfIntervals.push(intervals[0]);
        int i=1;
        while(i < intervals.length) {
            int[] availableRange = stackOfIntervals.pop();
            int highestAvailable = availableRange[1];
            int leastNext = intervals[i][0];
            if(highestAvailable>=leastNext) {
                if(availableRange[0] > intervals[i][0] && availableRange[0] > intervals[i][1]) {
                    stackOfIntervals.push(intervals[i]);
                    stackOfIntervals.push(availableRange);
                }
                else {
                    if(availableRange[0] >= intervals[i][0])
                        availableRange[0] = intervals[i][0];
                    if(availableRange[1] <= intervals[i][1])
                        availableRange[1] = intervals[i][1];
                    stackOfIntervals.push(availableRange);
                }
            }
            else {
                stackOfIntervals.push(availableRange);
                stackOfIntervals.push(intervals[i]);
            }
            i++;
        }
        
        Stack<int[]> intermediateStack = new Stack<>();
        while(!stackOfIntervals.empty()) {
            intermediateStack.push(stackOfIntervals.pop());
        }
        int[][] result = new int[intermediateStack.size()][2];
        int index = 0;
        while(!intermediateStack.empty()) {
            int[] res = intermediateStack.pop();
            result[index][0] = res[0];
            result[index][1] = res[1];
            index++;
        }
        return result;
    }
}
