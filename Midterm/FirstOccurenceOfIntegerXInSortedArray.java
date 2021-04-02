package Midterm;

/**
 * Implemented Binary search
 * Time Complexity = O(logn)
 * Space Complexity = O(1)
 */

public class FirstOccurenceOfIntegerXInSortedArray {
    public static int getIndex(int[] nums, int x)
    {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;
 
        while (left <= right)
        {
            int mid = (left + right) / 2;
 
            if (x == nums[mid])
            {
                result = mid;
                right = mid - 1;
            }
 
            else if (x < nums[mid]) {
                right = mid - 1;
            }
 
            else {
                left = mid + 1;
            }
        }
 
        return result;
    }
 
    public static void main(String[] args)
    {
        int[] num = {2,4,4,4,6,7,7,7,8,9,9,9};
        int key = 7;
        // int[] num = {1,2,2,3,4,4,4,4};
        // int key = 5;
        // int[] num = {1,1,1,1,1,1,1,1};
        // int key = 1;
 
        int index = getIndex(num, key);
 
        if (index != -1)
        {
            System.out.println(index);
        }
        else {
            System.out.println("Key "+key+" is not found in the array");
        }
    }
}
