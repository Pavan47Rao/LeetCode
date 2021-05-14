/**
x is a good number if after rotating each digit individually by 180 degrees, we get a valid number that is different from x. Each digit must be rotated - we cannot choose to leave it alone.

A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves; 2 and 5 rotate to each other (on this case they are rotated in a different direction, in other words 2 or 5 gets mirrored); 6 and 9 rotate to each other, and the rest of the numbers do not rotate to any other number and become invalid.

Now given a positive number n, how many numbers x from 1 to n are good?

Example:
Input: 10
Output: 4
Explanation: 
There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
Note:

n will be in range [1, 10000].
 */

package Easy;
import java.util.*;

public class RotatedDigits {
    private static final char[] same = {'0', '1', '8'};
    private static final char[] diff = {'2', '5', '6', '9'};
    private int count = 0;
    private String num;
    
    public int rotatedDigits(int n) {
        this.num = String.valueOf(n);
        for(int i = 1; i <= num.length(); i++)
            helper(0, new char[i], false);
        return this.count;
    }
    
    public void helper(int index, char[] cur, boolean valid) {
        if(index == cur.length) {
            if(!valid)
                return;
            String res = new String(cur);
            if(!(res.length() == this.num.length() && res.compareTo(this.num) > 0))
                this.count++;
            return;
        }
        for(char ch: same) {
            if(ch == '0' && index == 0)
                continue;
            cur[index] = ch;
            helper(index+1, cur, valid);
        }
        for(char ch: diff) {
            cur[index] = ch;
            helper(index+1, cur, true);
        }
    }
}