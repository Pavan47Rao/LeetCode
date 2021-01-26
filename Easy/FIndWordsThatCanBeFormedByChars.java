/**
 * You are given an array of strings words and a string chars.

A string is good if it can be formed by characters from chars (each character can only be used once).

Return the sum of lengths of all good strings in words.

 

Example 1:

Input: words = ["cat","bt","hat","tree"], chars = "atach"
Output: 6
Explanation: 
The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
Example 2:

Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
Output: 10
Explanation: 
The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
 

Note:

1 <= words.length <= 1000
1 <= words[i].length, chars.length <= 100
All strings contain lowercase English letters only.
 */

package Easy;

public class FIndWordsThatCanBeFormedByChars {
    public int countCharacters(String[] words, String chars) {
        int[] charCount = new int[26];
        int totalCount = 0;
        for(int i=0;i<chars.length();i++) {
            charCount[chars.charAt(i)-'a']++;   
        }
        for(String input: words) {
            int[] localCharCount = charCount.clone();
            int inputWordCount = input.length();
            int secondaryCount = 0;
            for(int i=0;i<input.length();i++) {
                if(localCharCount[input.charAt(i)-'a'] > 0) {
                    localCharCount[input.charAt(i)-'a']--;  
                    secondaryCount++;
                }
                else 
                    break;
            }
            if(secondaryCount == inputWordCount) {
                totalCount += inputWordCount;
            }
        }
        return totalCount;
    }
}
