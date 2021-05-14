/**
Given an integer n, return all the strobogrammatic numbers that are of length n. You may return the answer in any order.

A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

 

Example 1:

Input: n = 2
Output: ["11","69","88","96"]
Example 2:

Input: n = 1
Output: ["0","1","8"]
 

Constraints:

1 <= n <= 14
 */

package Medium;
import java.util.*;

public class StrobogrammaticNumber2 {
    
    List<String> result = new ArrayList<>();
    char[][] map = {{'0','0'},{'1','1'},{'6','9'},{'8','8'},{'9','6'}};
    public List<String> findStrobogrammatic(int n) {
        helper(0, n-1, new char[n]);
        return result;
    }

    public void helper(int left, int right, char[] cur) {
        if(left > right) {
            result.add(new String(cur));
            return;
        }

        for(char[] pair: map) {
            cur[left] = pair[0];
            cur[right] = pair[1];

            if(cur.length != 1 && cur[0] == '0')
                continue;
            if(left == right && pair[0] != pair[1])
                continue;

            helper(left+1, right-1, cur);
        }
    }
}