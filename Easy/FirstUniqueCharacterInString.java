/**
 * Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode"
return 2.
 

Note: You may assume the string contains only lowercase English letters.


 */

package Easy;
import java.util.*;

public class FirstUniqueCharacterInString {
    public int firstUniqChar(String s) {
        Map<Character,Integer> charMap = new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++)
            charMap.put(s.charAt(i),charMap.getOrDefault(s.charAt(i),0)+1);
        for(int i=0;i<s.length();i++) {
            if(charMap.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}
