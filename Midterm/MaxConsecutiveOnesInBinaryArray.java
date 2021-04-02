package Midterm;

/**
 * Time complexity = O(n)
 * Space complexity = O(1)
 */

public class MaxConsecutiveOnesInBinaryArray {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0, count = 0;
        for(int i=0; i< nums.length;i++) {
            if(nums[i] == 1) {
                count++;
                maxCount = Math.max(maxCount, count);
            }
            else 
                count = 0;
        }
        return maxCount;
    }

    public static void main(String args[]) {
        int[] nums = {0,1,1,0,1,1,1,1,0};
        System.out.println(findMaxConsecutiveOnes(nums));
        int[] nums2 = {1};
        System.out.println(findMaxConsecutiveOnes(nums2));
        int[] nums3 = {0};
        System.out.println(findMaxConsecutiveOnes(nums3));
        int[] nums4 = {1,1,1,1,1,1,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums4));
    }
}
