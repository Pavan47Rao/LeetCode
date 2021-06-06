/**
Given an integer array nums and an integer k, return the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

 

Example 1:

Input: nums = [1,-1,5,-2,3], k = 3
Output: 4
Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
Example 2:

Input: nums = [-2,-1,2,1], k = 1
Output: 2
Explanation: The subarray [-1, 2] sums to 1 and is the longest.
 

Constraints:

1 <= nums.length <= 2 * 105
-104 <= nums[i] <= 104
-109 <= k <= 109
 */

package Medium;
import java.util.*;

public class MaxSizeSubarraySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) { 
        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, -1);
        int maxLength = 0, currentSum = 0;
        for(int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if(sumMap.containsKey(currentSum - k))
                maxLength = Math.max(maxLength, i - sumMap.get(currentSum-k));
            if(!sumMap.containsKey(currentSum))
                sumMap.put(currentSum, i);
        }
        return maxLength;
    }
}