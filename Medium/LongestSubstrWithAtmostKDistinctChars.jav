/**
Given a string s and an integer k, return the length of the longest substring of s that contains at most k distinct characters.

 

Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: The substring is "ece" with length 3.
Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: The substring is "aa" with length 2.
 

Constraints:

1 <= s.length <= 5 * 104
0 <= k <= 50
 */

package Medium;
import java.util.*;

public class LongestSubstrWithAtmostKDistinctChars {
    public int lengthOfLongestSubstringKDistinct(String str, int k) {
        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        // in the following loop we'll try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
          char rightChar = str.charAt(windowEnd);
          charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);
          // shrink the sliding window, until we are left with 'k' distinct characters in the frequency map
          while (charFrequencyMap.size() > k) {
            char leftChar = str.charAt(windowStart);
            charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
            if (charFrequencyMap.get(leftChar) == 0) {
              charFrequencyMap.remove(leftChar);
            }
            windowStart++; // shrink the window
          }
          maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maximum length so far
        }

        return maxLength;
    }
}