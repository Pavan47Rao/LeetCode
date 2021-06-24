/**
 * Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.

Return the maximum possible length of s.

 

Example 1:

Input: arr = ["un","iq","ue"]
Output: 4
Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
Maximum length is 4.
Example 2:

Input: arr = ["cha","r","act","ers"]
Output: 6
Explanation: Possible solutions are "chaers" and "acters".
Example 3:

Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
Output: 26
 

Constraints:

1 <= arr.length <= 16
1 <= arr[i].length <= 26
arr[i] contains only lower case English letters.

 */

package Medium;
import java.util.*;

public class MaxLengthOfConcatenatedStrWithUniqueChar {
    public int maxLength(List<String> arr) {
        return maxLength(arr, 0, 0, new int[26], new ArrayList<>());
    }
    
    public int maxLength(List<String> arr, int index, int curLen, int[] curCharCount, List<String> curStrings) {
        if(index == arr.size())
            return curLen;
        int maxLen = curLen;
        for(int i = index; i < arr.size(); i++) {
            String nextStr = arr.get(i);
            int[] nextCharCount = findCount(nextStr, curCharCount);
            if(isUnique(nextCharCount)) {
                curStrings.add(nextStr);
                curLen += nextStr.length();
                maxLen = Math.max(maxLen, maxLength(arr, i+1, curLen, nextCharCount, curStrings));
                curLen -= nextStr.length();
                curStrings.remove(curStrings.size()-1);
            }
        }
        return maxLen;
    }
    
    public int[] findCount(String s, int[] count) {
        int[] nextCharCount = count.clone();
        for(char ch: s.toCharArray()) {
            nextCharCount[ch-'a']++;
        }
        return nextCharCount;
    }
    
    public boolean isUnique(int[] count) {
        for(int c: count)
            if(c > 1)
                return false;
        return true;
    }
}
