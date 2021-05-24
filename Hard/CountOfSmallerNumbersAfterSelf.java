/**
You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

 

Example 1:

Input: nums = [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
Example 2:

Input: nums = [-1]
Output: [0]
Example 3:

Input: nums = [-1,-1]
Output: [0,0]
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104

 */

package Hard;
import java.util.*;

public class CountOfSmallerNumbersAfterSelf {
    //Binary indexed tree approach
    public List<Integer> countSmaller(int[] nums) {
        int offset = 10000;
        int size = (2*offset)+2;
        int[] tree = new int[size];
        List<Integer> result = new ArrayList<>();
        for(int i=nums.length-1; i >= 0; i--) {
            int count = query(nums[i] + offset, tree);
            result.add(count);
            update(nums[i]+offset, 1, tree, size);
        }
        Collections.reverse(result);
        return result;
    }
    
    public void update(int index, int value, int[] tree, int size) {
        index++;
        while(index < size) {
            tree[index] += value;
            index += index & (-index);
        }
    }
    
    public int query(int index, int[] tree) {
        int result = 0;
        while(index >= 1) {
            result += tree[index];
            index -= index & (-index);
        }
        return result;
    }
}