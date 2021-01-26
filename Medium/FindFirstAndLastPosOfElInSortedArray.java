/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

Follow up: Could you write an algorithm with O(log n) runtime complexity?

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
 */

package Medium;

import java.util.*;
import java.util.stream.Collectors;

public class FindFirstAndLastPosOfElInSortedArray {
    int findIndexOfTarget(int l, int r, int target, int[] a) {
        int mid = (l+r)/2;
        if(a[mid] == target) {
            return mid;
        }
            
        else if(a[mid] < target)
            return findIndexOfTarget(mid+1, r, target, a);
        else 
            return findIndexOfTarget(l, mid-1, target, a);
    }
    
    int[] findFirstAndLastIndex(int index, int target, int[] nums, int[] result) {
        int firstIndex = index, lastIndex = index;
        while(firstIndex >= 0 && firstIndex-1>=0 && nums[firstIndex-1] == target) {
            firstIndex--;
        }
        while(lastIndex < nums.length && lastIndex+1<=nums.length-1 && nums[lastIndex+1] == target) {
            lastIndex++;
        }
        result[0] = firstIndex;
        result[1] = lastIndex;
        return result;
    }
    
    public int[] searchRange(int[] nums, int target) {
        int result[] = {-1, -1};
        List<Integer> listForQuickSearch = new ArrayList<>();
        listForQuickSearch = Arrays.stream(nums).boxed().collect(Collectors.toList());
        if(!listForQuickSearch.contains(target) || listForQuickSearch.size()==0) {
            return result;
        }
        if(nums.length == 1) {
            if(nums[0] == target) {
                result[0] = 0;
                result[1] = 0;
                return result;
            }
            return result;
        }
        else {
            int index = findIndexOfTarget(0, nums.length-1, target, nums);
            System.out.println(index);
            return findFirstAndLastIndex(index, target, nums, result);
        }
    }
}
