/**
 * Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]

Note:

Each element in the result must be unique.
The result can be in any order.
 */

package Easy;
import java.util.*;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> uniqueNums = new HashSet<>();
        for(Integer num: nums1){
            uniqueNums.add(num);
        }
        List<Integer> res1 = new ArrayList<>();
        for(Integer num: nums2) {
            if(uniqueNums.contains(num))
                res1.add(num);
                uniqueNums.remove(num);
        }
        int[] res = new int[res1.size()];
        for(int i=0; i<res1.size(); i++) {
            res[i] = res1.get(i);
        }
        return res;
    }
}
