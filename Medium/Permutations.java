/**
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:

Input: nums = [1]
Output: [[1]]
 

Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
 */

package Medium;

import java.util.*;
import java.util.stream.Collectors;

public class Permutations {
    public void permute(List<Integer> arr, int first, int n, List<List<Integer>> result) {
        if(first == n)
            result.add(new ArrayList<Integer>(arr));
        for(int i=first;i<n;i++) {
            Collections.swap(arr, first, i);
            permute(arr, first+1, n, result);
            Collections.swap(arr, first,i);
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> arr = Arrays.stream(nums).boxed().collect(Collectors.toList());
        permute(arr, 0, nums.length, result);
        return result;
    }
}
