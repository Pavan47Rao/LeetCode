/**
Given a binary array nums, you should delete one element from it.

Return the size of the longest non-empty subarray containing only 1's in the resulting array.

Return 0 if there is no such subarray.

 

Example 1:

Input: nums = [1,1,0,1]
Output: 3
Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
Example 2:

Input: nums = [0,1,1,1,0,1,1,0,1]
Output: 5
Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
Example 3:

Input: nums = [1,1,1]
Output: 2
Explanation: You must delete one element.
Example 4:

Input: nums = [1,1,0,0,1,1,1,0,1]
Output: 4
Example 5:

Input: nums = [0,0,0]
Output: 0
 

Constraints:

1 <= nums.length <= 10^5
nums[i] is either 0 or 1. */

package Medium;
import java.util.*;

class LongestSubArrayOf1sAfterDeleting1Element {
    public int longestSubarray(int[] arr) {
        int k = 1;
        int windowStart = 0, maxLength = 0, maxOnesCount = 0;
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
          if (arr[windowEnd] == 1)
            maxOnesCount++;

          // current window size is from windowStart to windowEnd, overall we have a maximum of 1s
          // repeating a maximum of 'maxOnesCount' times, this means that we can have a window with
          // 'maxOnesCount' 1s and the remaining are 0s which should replace with 1s.
          // now, if the remaining 0s are more than 'k', it is the time to shrink the window as we
          // are not allowed to replace more than 'k' Os
          if (windowEnd - windowStart + 1 - maxOnesCount > k) {
            if (arr[windowStart] == 1)
              maxOnesCount--;
            windowStart++;
          }

          maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength-1;
      }
}