/**
Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.

 

Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: 1
 

Constraints:

1 <= intervals.length <= 104
0 <= starti < endi <= 106
 */

package Medium;
import java.util.*;

public class MeetingRooms2 {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0)
            return 0;
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        PriorityQueue<Integer> allocator = new PriorityQueue<Integer>(intervals.length, (a,b) -> Integer.compare(a,b));
        allocator.add(intervals[0][1]);
        for(int i=1;i<intervals.length;i++) {
            if(intervals[i][0] >= allocator.peek())
                allocator.poll();
            allocator.add(intervals[i][1]);
        }
        return allocator.size();
    }
}