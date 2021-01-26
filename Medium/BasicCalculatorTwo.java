/**
 * Given a string s which represents an expression, evaluate this expression and return its value. 

The integer division should truncate toward zero.

 

Example 1:

Input: s = "3+2*2"
Output: 7
Example 2:

Input: s = " 3/2 "
Output: 1
Example 3:

Input: s = " 3+5 / 2 "
Output: 5
 

Constraints:

1 <= s.length <= 3 * 105
s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
s represents a valid expression.
All the integers in the expression are non-negative integers in the range [0, 231 - 1].
The answer is guaranteed to fit in a 32-bit integer.
 */

package Medium;
import java.util.*;

public class BasicCalculatorTwo {
    public int calculate(String s) {
        Stack<Integer> cal = new Stack<>();
        int currentNumber = 0, i = 0;
        char operation = '+';
        if(s == null || s.length() == 0)
            return 0;
        for(char ch: s.toCharArray()) {
            if(Character.isDigit(ch))
                currentNumber = (currentNumber * 10) + ch - '0';
            if(!Character.isDigit(ch) && !Character.isWhitespace(ch) || i==s.length()-1) {
                if(operation == '+')
                    cal.push(currentNumber);
                else if(operation == '-')
                    cal.push(-currentNumber);
                else if(operation == '*')
                    cal.push(cal.pop()*currentNumber);
                else if(operation == '/')
                    cal.push(cal.pop()/currentNumber);
                currentNumber = 0;
                operation = ch;
            }
            i++;
        }
        int result = 0;
        while(!cal.isEmpty())
            result += cal.pop();
        return result;
    }
}
