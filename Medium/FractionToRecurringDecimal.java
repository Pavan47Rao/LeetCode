/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

If multiple answers are possible, return any of them.

It is guaranteed that the length of the answer string is less than 104 for all the given inputs.

 

Example 1:

Input: numerator = 1, denominator = 2
Output: "0.5"
Example 2:

Input: numerator = 2, denominator = 1
Output: "2"
Example 3:

Input: numerator = 2, denominator = 3
Output: "0.(6)"
Example 4:

Input: numerator = 4, denominator = 333
Output: "0.(012)"
Example 5:

Input: numerator = 1, denominator = 5
Output: "0.2"
 

Constraints:

-231 <= numerator, denominator <= 231 - 1
denominator != 0
 */

package Medium;
import java.util.*;

public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0)
            return "0";
        StringBuilder res = new StringBuilder();
        if(numerator < 0 ^ denominator < 0)
            res.append("-");
        
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        res.append(String.valueOf(dividend / divisor));
        long remainder = dividend % divisor;
        if(remainder == 0)
            return res.toString();
        res.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while(remainder != 0) {
            if(map.containsKey(remainder)) {
                res.insert(map.get(remainder), "(");
                res.append(")");
                break;
            }
            map.put(remainder, res.length());
            remainder *= 10;
            res.append(String.valueOf(remainder/divisor));
            remainder %= divisor;
        }
        return res.toString();
    }
}
