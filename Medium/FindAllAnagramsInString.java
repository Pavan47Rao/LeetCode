/**
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

 

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 

Constraints:

1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters.
 */

package Medium;
import java.util.*;

class FindAllAnagramsInString {
    public List<Integer> findAnagrams(String str, String pattern) {
        int windowStart = 0, matched = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char chr : pattern.toCharArray())
          charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);

        List<Integer> resultIndices = new ArrayList<Integer>();
        // our goal is to match all the characters from the map with the current window
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
          char rightChar = str.charAt(windowEnd);
          // decrement the frequency of the matched character
          if (charFrequencyMap.containsKey(rightChar)) {
            charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
            if (charFrequencyMap.get(rightChar) == 0)
              matched++;
          }

          if (matched == charFrequencyMap.size()) // have we found an anagram?
            resultIndices.add(windowStart);

          if (windowEnd >= pattern.length() - 1) { // shrink the window
            char leftChar = str.charAt(windowStart++);
            if (charFrequencyMap.containsKey(leftChar)) {
              if (charFrequencyMap.get(leftChar) == 0)
                matched--; // before putting the character back, decrement the matched count
              // put the character back
              charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
            }
          }
        }

        return resultIndices;
      }
}