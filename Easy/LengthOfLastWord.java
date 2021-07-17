/**
 * Given a string s consists of some words separated by spaces, return the length of the last word in the string. If the last word does not exist, return 0.

A word is a maximal substring consisting of non-space characters only.

 

Example 1:

Input: s = "Hello World"
Output: 5
Example 2:

Input: s = " "
Output: 0
 

Constraints:

1 <= s.length <= 104
s consists of only English letters and spaces ' '.
 */

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int length = 0;
        if(s == " ")
            return 0;
        else{
            String newString = s.trim();
            for(int i = newString.length()-1; i >= 0; i--) {
                if(newString.charAt(i) != ' ')
                    length++;
                else
                    return length;
            }
        }
        return length;
    }
}
