/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 

Example 1:

Input: s = "()"
Output: true

Example 2:

Input: s = "()[]{}"
Output: true

Example 3:

Input: s = "(]"
Output: false

Example 4:

Input: s = "([)]"
Output: false

Example 5:

Input: s = "{[]}"
Output: true
 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
 */

package Easy;
import java.util.*;

public class ValidParentheses {
    public boolean isValid(String s) {
        
        HashMap<Character, Character> bracesMap = new HashMap<>();
        bracesMap.put(')','(');
        bracesMap.put(']','[');
        bracesMap.put('}','{');
        
        Stack<Character> inputStack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            Character inputChar = s.charAt(i);
		    if(bracesMap.containsKey(inputChar)) {
		        Character topElement = inputStack.isEmpty() ? '#' : inputStack.pop();
		        if(!topElement.equals(bracesMap.get(inputChar)))
		        return false;
		    }
		    else
		        inputStack.push(inputChar);
		}
		
		if(!inputStack.isEmpty())
		return false;
		else
		return true;
    }
}
