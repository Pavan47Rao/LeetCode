/**
Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

 

Example 1:

Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".
Example 2:

Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".
Example 3:

Input: s = "a##c", t = "#a#c"
Output: true
Explanation: Both s and t become "c".
Example 4:

Input: s = "a#c", t = "b"
Output: false
Explanation: s becomes "c" while t becomes "b".
 

Constraints:

1 <= s.length, t.length <= 200
s and t only contain lowercase letters and '#' characters.
 */

package Easy;

class BackspaceStringCompare{
    public boolean backspaceCompare(String s, String t) {
        int index1 = s.length()-1, index2 = t.length()-1;
        while(index1 >= 0 || index2 >= 0) {
            int i1 = getIndex(s, index1);
            int i2 = getIndex(t, index2);
            if(i1 < 0 && i2 < 0)
                return true;
            if(i1 < 0 || i2 < 0)
                return false;
            if(s.charAt(i1) != t.charAt(i2))
                return false;
            index1 = i1-1;
            index2 = i2-1;
        }
        return true;
    }
    
    public int getIndex(String str, int index) {
        int escapeCount = 0;
        while(index >= 0) {
            if(str.charAt(index) == '#')
                escapeCount++;
            else if(escapeCount > 0)
                escapeCount--;
            else
                break;
            index--;
        }
        return index;
    }
}