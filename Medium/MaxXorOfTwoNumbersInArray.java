/**
 * Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 ≤ i ≤ j < n.

Follow up: Could you do this in O(n) runtime?

 

Example 1:

Input: nums = [3,10,5,25,2,8]
Output: 28
Explanation: The maximum result is 5 XOR 25 = 28.

Example 2:

Input: nums = [0]
Output: 0

Example 3:

Input: nums = [2,4]
Output: 6

Example 4:

Input: nums = [8,10,2]
Output: 10

Example 5:

Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70]
Output: 127
 

Constraints:

1 <= nums.length <= 2 * 104
0 <= nums[i] <= 231 - 1

 */

package Medium;
import java.util.*;

public class MaxXorOfTwoNumbersInArray {

    class TrieNode {
        public TrieNode() {}
        Map<Character, TrieNode> children = new HashMap<>();
    }
    

    public int findMaximumXOR(int[] nums) {
        int maxNum = nums[0];
        for(int num: nums)
            if(num > maxNum)
                maxNum = num;
        int maxL = Integer.toBinaryString(maxNum).length();
        
        int n = nums.length;
        String[] strings = new String[n];
        int mask = 1 << maxL;
        for(int i=0;i<n;i++)
            strings[i] = (Integer.toBinaryString(nums[i] | mask)).substring(1);
        
        TrieNode trie = new TrieNode();
        int maxXor = 0;
        for(String str: strings) {
            TrieNode node = trie, xorNode = trie;
            int curXor = 0;
            
            for(Character bit: str.toCharArray()) {
                if(node.children.containsKey(bit))
                    node = node.children.get(bit);
                else {
                    TrieNode newNode = new TrieNode();
                    node.children.put(bit, newNode);
                    node = newNode;
                }
                
                Character toggledBit = bit == '1' ? '0' : '1';
                if(xorNode.children.containsKey(toggledBit)) {
                    curXor = curXor << 1 | 1;
                    xorNode = xorNode.children.get(toggledBit);
                }
                else {
                    curXor = curXor << 1;
                    xorNode = xorNode.children.get(bit);
                }
            }
            maxXor = Math.max(maxXor, curXor);
        }
        return maxXor;
    }
}
