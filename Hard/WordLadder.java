/**
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words such that:

The first word in the sequence is beginWord.
The last word in the sequence is endWord.
Only one letter is different between each adjacent pair of words in the sequence.
Every word in the sequence is in wordList.
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog" with 5 words.
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no possible transformation.
 

Constraints:

1 <= beginWord.length <= 10
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the strings in wordList are unique.

 */

package Hard;
import java.util.*;

public class WordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int count = 1; 
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                char[] current = queue.poll().toCharArray();
                for(int j=0;j<current.length;j++) {
                    char temp = current[j];
                    for(char c='a';c<='z';c++) {
                        current[j] = c;
                        String next = new String(current);
                        if(words.contains(next)) {
                            if(next.equals(endWord))
                                return count+1;
                            words.remove(next);
                            queue.add(next);
                        }
                    }
                    current[j] = temp;
                }
            }
            count++;
        }
        return 0;
    }

    public static void main(String args[]) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] words = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        System.out.println("Number of words in the shortest transformation sequence from beginWord to endWord is " + ladderLength(beginWord, endWord, wordList));
    }
}
