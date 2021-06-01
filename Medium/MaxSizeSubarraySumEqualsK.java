/**

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