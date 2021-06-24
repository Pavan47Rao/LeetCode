/**
 * Given an array nums, partition it into two (contiguous) subarrays left and right so that:

Every element in left is less than or equal to every element in right.
left and right are non-empty.
left has the smallest possible size.
Return the length of left after such a partitioning.  It is guaranteed that such a partitioning exists.

 

Example 1:

Input: nums = [5,0,3,8,6]
Output: 3
Explanation: left = [5,0,3], right = [8,6]
Example 2:

Input: nums = [1,1,1,0,6,12]
Output: 4
Explanation: left = [1,1,1,0], right = [6,12]
 

Note:

2 <= nums.length <= 30000
0 <= nums[i] <= 106
It is guaranteed there is at least one way to partition nums as described.

 */

package Medium;

public class PartitionArrayIntoDisjointIntervals {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] leftMax = new int[n];
        int[] rightMin = new int[n];
        int m = nums[0];
        for(int i = 0; i < n; i++) {
            m = Math.max(m, nums[i]);
            leftMax[i] = m;
        }
        m = nums[n-1];
        for(int i = n-1; i >= 0; i--) {
            m = Math.min(m, nums[i]);
            rightMin[i] = m;
        }
        for(int i = 1; i < n; i++){
            if(leftMax[i-1] <= rightMin[i])
                return i;
        }
        throw null;
    }
}
