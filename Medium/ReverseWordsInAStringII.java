/**
 * Given a character array s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by a single space.

Your code must solve the problem in-place, i.e. without allocating extra space.

 

Example 1:

Input: s = ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
Example 2:

Input: s = ["a"]
Output: ["a"]
 

Constraints:

1 <= s.length <= 105
s[i] is an English letter (uppercase or lowercase), digit, or space ' '.
There is at least one word in s.
s does not contain leading or trailing spaces.
All the words in s are guaranteed to be separated by a single space.
 */

package Medium;

public class ReverseWordsInAStringII {

    public void reverse(char[] s, int left, int right) {
        while(left < right) {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }

    public void reverseEachWord(char[] s) {
        int n = s.length;
        int start = 0, end = 0;
        while(start < n) {
            while(end < n && s[start] != ' ')
                end++;
            reverse(s, start, end-1);
            start = end+1;
            end++;
        }
    }

    public void reverseWords(char[] s) {
        reverse(s, 0, s.length-1);
        reverseEachWord(s);
    }
}
