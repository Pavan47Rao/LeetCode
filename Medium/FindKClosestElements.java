/**
 * Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
 

Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
Example 2:

Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]
 

Constraints:

1 <= k <= arr.length
1 <= arr.length <= 104
arr is sorted in ascending order.
-104 <= arr[i], x <= 104

 */

package Medium;
import java.util.*;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        for(int i: arr)
            res.add(i);
        Collections.sort(res, (a,b) -> a == b ? a-b : Math.abs(a - x) - Math.abs(b - x));
        res = res.subList(0, k);
        Collections.sort(res);
        return res;
    }
}

/**
 * Binary search approach:
 * public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k;
        while(left < right) {
            int mid = (left + right) / 2;
            if(x-arr[mid] > arr[mid+k]-x)
                left = mid+1;
            else
                right = mid;
        }
        List<Integer> result = new ArrayList<>();
        for(int i = left; i < left+k; i++)
            result.add(arr[i]);
        return result;
    }
 */
