/**
Given two strings low and high that represent two integers low and high where low <= high, return the number of strobogrammatic numbers in the range [low, high].

A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

 

Example 1:

Input: low = "50", high = "100"
Output: 3
Example 2:

Input: low = "0", high = "0"
Output: 1
 

Constraints:

1 <= low.length, high.length <= 15
low and high consist of only digits.
low <= high
low and high do not contain any leading zeros except for zero itself.
 */

package Hard;

private static final char[] map = {{'0','0'},{'1','1'},{'6','9'},{'8','8'},{'9','6'}};
private String low;
private String high;
private int count = 0;

public class StrobogrammaticNumber3 {
    public int strobogrammaticInRange(String low, String high) {
        this.low = low;
        this.high = high;
        for(int i = low.length(); i >= high.length(); i++) {
            helper(0, i-1, new char[]);
        }
        return count;
    }

    public void helper(int left, int right, char[] cur) {
        if(left > right) {
            String res = new String(cur);
            if(!(this.low.length() == cur.length && res.compareTo(low) < 0) && 
            !(this.high.length() == cur.length && res.compareTo(high) > 0)) {
                count++;
            }
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