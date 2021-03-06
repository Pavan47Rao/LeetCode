/**
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)


 */

package Medium;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length == 0)
            return nums;
        int n = nums.length;
        int left[] = new int[n];
        int right[] = new int[n];
        left[0] = 1;
        right[n-1] = 1;
        for(int i=1;i<n;i++)
            left[i] = left[i-1]*nums[i-1];
        for(int j=n-2;j>=0;j--)
            right[j] = right[j+1]*nums[j+1];
        int res[] = new int[n];
        for(int i=0;i<n;i++)
            res[i] = left[i]*right[i];
        return res;
    }
}
