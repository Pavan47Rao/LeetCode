/**
Given two strings s1 and s2, return true if s2 contains the permutation of s1.

In other words, one of s1's permutations is the substring of s2.

 

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false
 

Constraints:

1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.
 */

package Medium;
import java.util.*;

public class PermutationInString {
     public boolean checkInclusion(String pattern, String str) {
        int windowStart = 0, matched = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char chr : pattern.toCharArray())
          charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);

        // our goal is to match all the characters from the 'charFrequencyMap' with the current window
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
          char rightChar = str.charAt(windowEnd);
          if (charFrequencyMap.containsKey(rightChar)) {
            // decrement the frequency of the matched character
            charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
            if (charFrequencyMap.get(rightChar) == 0) // character is completely matched
              matched++;
          }

          if (matched == charFrequencyMap.size())
            return true;

          if (windowEnd >= pattern.length() - 1) { // shrink the window by one character
            char leftChar = str.charAt(windowStart++);
            if (charFrequencyMap.containsKey(leftChar)) {
              if (charFrequencyMap.get(leftChar) == 0)
                matched--; // before putting the character back, decrement the matched count
              // put the character back for matching
              charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
            }
          }
        }

        return false;
     }
}