/**
Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

 

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
 

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 100
 */

package Medium;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++)
            sum += nums[i];
        if(sum % 2 != 0)
            return false;
        sum /= 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n][sum+1];
        for(int i = 0; i < dp.length; i++)
            dp[i][0] = true;
        for(int s = 0; s <= sum; s++)
            dp[0][s] = nums[0] == s ? true : false;
        for(int i = 1; i < nums.length; i++) {
            for(int s = 1; s <= sum; s++) {
                if(dp[i-1][s])
                    dp[i][s] = dp[i-1][s];
                else if(s >= nums[i])
                    dp[i][s] = dp[i-1][s-nums[i]];
            }
        }
        return dp[n-1][sum];
    }
}