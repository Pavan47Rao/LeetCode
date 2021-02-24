/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

 

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]

Example 3:

Input: nums = [0]
Output: [0]

Example 4:

Input: nums = [1]
Output: [1]
 

Constraints:

n == nums.length
1 <= n <= 300
nums[i] is 0, 1, or 2.
 

Follow up:

Could you solve this problem without using the library's sort function?
Could you come up with a one-pass algorithm using only O(1) constant space?
 */

package Medium;

public class SortColours {
    public void sortColors(int[] nums) {
        int p0 = 0, p2 = nums.length - 1, cur = 0;
        int temp;
        while(cur <= p2) {
            if(nums[cur] == 0) {
                temp = nums[cur];
                nums[cur++] = nums[p0];
                nums[p0++] = temp;
            }
            else if(nums[cur] == 2) {
                temp = nums[cur];
                nums[cur] = nums[p2];
                nums[p2--] = temp;
            }
            else
                cur++;
        }
    }
}
