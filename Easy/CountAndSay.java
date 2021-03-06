/**
 * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

countAndSay(1) = "1"
countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
To determine how you "say" a digit string, split it into the minimal number of groups so that each group is a contiguous section all of the same character. Then for each group, say the number of characters, then say the character. To convert the saying into a digit string, replace the counts with a number and concatenate every saying.

For example, the saying and conversion for digit string "3322251":

Given a positive integer n, return the nth term of the count-and-say sequence.

 

Example 1:

Input: n = 1
Output: "1"
Explanation: This is the base case.

Example 2:

Input: n = 4
Output: "1211"
Explanation:
countAndSay(1) = "1"
countAndSay(2) = say "1" = one 1 = "11"
countAndSay(3) = say "11" = two 1's = "21"
countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
 

Constraints:

1 <= n <= 30
 */

package Easy;

public class CountAndSay {
    public static String calculate(String n) {
        int count = 1;
        String result = "";
        Character ch = n.charAt(0);
        for(int i=1;i<n.length(); i++) {
            Character nextChar = n.charAt(i);
            if(ch == nextChar) {
                count++;
            }
            else {
                result += Integer.toString(count) + Character.toString(ch);
                ch = nextChar;
                count = 1;
            }
        }
        result += Integer.toString(count) + Character.toString(ch);
        return result;
    }
    
    public static String countAndSay(int n) {
        if(n == 1) {
            return "1";
        }   
        String result = "1";
        for(int i=2; i<=n; i++) {
            result = calculate(result);
        }
        return result;
    }
}
