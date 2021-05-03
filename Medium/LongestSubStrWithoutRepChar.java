/**
 * Given a string s, find the length of the longest substring without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Example 4:

Input: s = ""
Output: 0
 
Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.

 */

package Medium;
import java.util.*;

public class LongestSubStrWithoutRepChar {
    public int lengthOfLongestSubstring(String s) {
        int i=0, j=0;
        Set<Character> uniqueChars = new HashSet<>();
        int n = s.length(), ans = 0;
        while(i<n && j<n) {
            if(uniqueChars.contains(s.charAt(j))) {
                uniqueChars.remove(s.charAt(i++));
            }
            else {
                uniqueChars.add(s.charAt(j++));
                ans = Math.max(ans, j-i);
            }
        }
        return ans;
    }
}

/**
Sliding window approach:

public int lengthOfLongestSubstring(String str) {
        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
          char rightChar = str.charAt(windowEnd);
          // if the map already contains the 'rightChar', shrink the window from the beginning so that
          // we have only one occurrence of 'rightChar'
          if (charIndexMap.containsKey(rightChar)) {
            // this is tricky; in the current window, we will not have any 'rightChar' after its previous index
            // and if 'windowStart' is already ahead of the last index of 'rightChar', we'll keep 'windowStart'
            windowStart = Math.max(windowStart, charIndexMap.get(rightChar) + 1);
          }
          charIndexMap.put(rightChar, windowEnd); // insert the 'rightChar' into the map
          maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maximum length so far
        }

        return maxLength;
     }
 */
