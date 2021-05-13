/**
Given a string num which represents an integer, return true if num is a strobogrammatic number.

A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

 

Example 1:

Input: num = "69"
Output: true
Example 2:

Input: num = "88"
Output: true
Example 3:

Input: num = "962"
Output: false
Example 4:

Input: num = "1"
Output: true
 

Constraints:

1 <= num.length <= 50
num consists of only digits.
num does not contain any leading zeros except for zero itself.
 */

package Easy;
import java.util.*;
public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>(Map.of('0','0','1','1','6','9','8','8','9','6'));
        for(int i = 0, j = num.length()-1; i <= j; i++, j--) {
            if(!map.containsKey(num.charAt(j)) || map.get(num.charAt(j)) != num.charAt(i))
                return false;
        }
        return true;
    }
}