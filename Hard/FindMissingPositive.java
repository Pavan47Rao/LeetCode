/**
Given an unsorted integer array nums, find the smallest missing positive integer.

You must implement an algorithm that runs in O(n) time and uses constant extra space.

 

Example 1:

Input: nums = [1,2,0]
Output: 3
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1
 

Constraints:

1 <= nums.length <= 5 * 105
-231 <= nums[i] <= 231 - 1
 */

package Hard;

public class FindMissingPositive {
    public int firstMissingPositive(int[] nums) {
        boolean containsOne = false;
        for(int i: nums)
            if(i == 1)
                containsOne = true;
        if(!containsOne)
            return 1;
        
        int n = nums.length;
        for(int i = 0; i < n; i++)
            if(nums[i] <= 0 || nums[i] > n)
                nums[i] = 1;
        
        for(int i = 0; i < n; i++) {
            int a = Math.abs(nums[i]);
            if(a == n)
                nums[0] = -Math.abs(nums[0]);
            else
                nums[a] = -Math.abs(nums[a]);
        }
        
        for(int i = 1; i < n; i++) {
            if(nums[i] > 0)
                return i;
        }
        
        if(nums[0] > 0)
            return n;
        
        return n+1;
    }
}