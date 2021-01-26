/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8
 */

package Medium;
import java.util.*;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }
    
    public void backtrack(List<String> result, String temp, int start, int end, int max) {
        if(temp.length() == 2*max) {
            result.add(temp);
            return;
        }    
        if(start<max)
            backtrack(result, temp+"(", start+1, end, max);
        if(end<start)
            backtrack(result, temp+")", start, end+1, max);
    }
}
