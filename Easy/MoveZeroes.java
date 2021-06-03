/**
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

 

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]
 

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
 

Follow up: Could you minimize the total number of operations done?
 */

package Easy;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        for(int lastZeroFoundAtIndex = 0, cur = 0; cur < nums.length; cur++) {
            if(nums[cur] != 0)
                swap(lastZeroFoundAtIndex++, cur, nums);
        }
    }
    
    public void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}