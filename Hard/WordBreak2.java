/**
 * Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
Output: ["cats and dog","cat sand dog"]
Example 2:

Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: []
 

Constraints:

1 <= s.length <= 20
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 10
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
 */

package Hard;
import java.util.*;

public class WordBreak2 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> sentences = new ArrayList<>();
        wordBreak(s, wordDict, sentences, 0, new LinkedList<String>());
        return sentences;
    }
    
    public void wordBreak(String s, List<String> wordDict, List<String> sentences, int start, Deque<String> sentence) {
        if(start == s.length())
            sentences.add(String.join(" ", sentence));
        else {
            for(String word: wordDict) {
                if(s.startsWith(word, start)) {
                    sentence.addLast(word);
                    wordBreak(s, wordDict, sentences, start+word.length(), sentence);
                    sentence.removeLast();
                }
            }
        }
    }
}
