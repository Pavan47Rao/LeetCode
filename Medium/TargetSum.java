/**
You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.

 

Example 1:

Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
Example 2:

Input: nums = [1], target = 1
Output: 1
 

Constraints:

1 <= nums.length <= 20
0 <= nums[i] <= 1000
0 <= sum(nums[i]) <= 1000
-1000 <= target <= 1000
 */

public class TargetSum {
    public int findTargetSumWays(int[] num, int s) {
        int totalSum = 0;
        for (int n : num){
            totalSum += n;
        }

        // if 's + totalSum' is odd, we can't find a subset with sum equal to '(s + totalSum) / 2'
        if((s + totalSum) % 2 == 1)
            return 0;

        int sum = (s + totalSum) / 2;

        int[] dp = new int[sum + 1];
        dp[0] = 1;

        // process all subsets for all sums
        for(int i=1; i <= num.length; i++) {
          for(int j=sum; j >= num[i-1]; j--) {
                dp[j] += dp[j-num[i-1]];
          }
        }

        return dp[sum];
     }
} 