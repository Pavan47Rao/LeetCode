/**
We can rotate digits by 180 degrees to form new digits. When 0, 1, 6, 8, 9 are rotated 180 degrees, they become 0, 1, 9, 8, 6 respectively. When 2, 3, 4, 5 and 7 are rotated 180 degrees, they become invalid.

A confusing number is a number that when rotated 180 degrees becomes a different number with each digit valid.(Note that the rotated number can be greater than the original number.)

Given a positive integer N, return the number of confusing numbers between 1 and N inclusive.

 

Example 1:

Input: 20
Output: 6
Explanation: 
The confusing numbers are [6,9,10,16,18,19].
6 converts to 9.
9 converts to 6.
10 converts to 01 which is just 1.
16 converts to 91.
18 converts to 81.
19 converts to 61.
Example 2:

Input: 100
Output: 19
Explanation: 
The confusing numbers are [6,9,10,16,18,19,60,61,66,68,80,81,86,89,90,91,98,99,100].
 

Note:

1 <= N <= 10^9

 */

package Hard;
import java .util.*;

private static final Map<Character, Character> map = new HashMap<>(Map.of('0','0','1','1','6','9','8','8','9','6'));
private static final char[] candidates = {'0','1','6','8','9'};
private int count = 0;
private String num;

public class ConfusingNumber2 {
    public int confusingNumberII(int N) {
        this.num = String.valueOf(N);
        for(int i = 1; i <= num.length(); i++) {
            helper(0, i-1, new char[i], false);
        }
        return count;
    }

    public void helper(int left, int right, char[] cur, boolean valid) {
        if(left > right) {
            if(!valid)
                return;
            String res = new String(cur);
            if(!(res.length() == num.length() && res.compareTo(num) > 0))
                count++;
            return;
        }
        if(left == right) {
            for(char ch: candidates) {
                cur[left] = ch;
                helper(left+1, right-1, cur, valid || ch == '6' || ch == '9');
            }
            return;
        }
        for(char l: candidates) {
            cur[left] = l;
            if(l == 0 && left == 0)
                continue;
            for(char r: candidates) {
                cur[right] = r;
                helper(left+1, right-1, cur, valid || map.get(l) != r);
            }

        }
    }
}