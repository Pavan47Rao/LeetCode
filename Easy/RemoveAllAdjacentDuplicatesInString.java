/**
 * Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.

We repeatedly make duplicate removals on S until we no longer can.

Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.

 

Example 1:

Input: "abbaca"
Output: "ca"
Explanation: 
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 

Note:

1 <= S.length <= 20000
S consists only of English lowercase letters.
 */

package Easy;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String S) {
        Stack<Character> inputString = new Stack<Character>();
        inputString.push(S.charAt(0));
        for(int i=1;i<S.length();i++) {
            if(inputString.size()>0 && S.charAt(i) == inputString.peek()){
                inputString.pop();
            }
            else {
                inputString.push(S.charAt(i));
            }
        }
        String output = "";
        Stack<Character> helper = new Stack<Character>();
        while(inputString.size()>0) {
            helper.push(inputString.pop());
        }
        while(helper.size()>0) {
            output += helper.pop();
        }
        return output;
    }
}
