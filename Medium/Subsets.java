/**
 * 
 */

package Medium;
import java.util.*;

public class Subsets {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        int[] arr = new int[nums.length];
        genBinarySequence(arr, nums, 0);
        return result;
    }
    
    public void genBinarySequence(int[] arr, int[] nums, int cur) {
        if(cur == nums.length) {
            addResult(arr, nums);
            return;
        }
        for(int i = 0; i < 2; i++) {
            arr[cur] = i;
            genBinarySequence(arr, nums, cur+1);
        }
    }
    
    public void addResult(int[] arr, int[] nums) {
        List<Integer> subResult = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 1)
                subResult.add(nums[i]);
        }
        result.add(subResult);
    }
}
