/**
There is a new alien language that uses the English alphabet. However, the order among the letters is unknown to you.

You are given a list of strings words from the alien language's dictionary, where the strings in words are sorted lexicographically by the rules of this new language.

Return a string of the unique letters in the new alien language sorted in lexicographically increasing order by the new language's rules. If there is no solution, return "". If there are multiple solutions, return any of them.

A string s is lexicographically smaller than a string t if at the first letter where they differ, the letter in s comes before the letter in t in the alien language. If the first min(s.length, t.length) letters are the same, then s is smaller if and only if s.length < t.length.

 

Example 1:

Input: words = ["wrt","wrf","er","ett","rftt"]
Output: "wertf"
Example 2:

Input: words = ["z","x"]
Output: "zx"
Example 3:

Input: words = ["z","x","z"]
Output: ""
Explanation: The order is invalid, so return "".
 

Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 100
words[i] consists of only lowercase English letters.
 */

package Hard;
import java.util.*;

class AlienDictionary {
    public String alienOrder(String[] words) {
        if(words== null || words.length == 0)
            return "";
        
        Map<Character, LinkedList<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        for(String word: words) {
            for(char ch: word.toCharArray()) {
                graph.put(ch, new LinkedList<>());
                indegree.put(ch, 0);
            }
        }
        
        for(int i = 0; i < words.length - 1; i++) {
            String word1 = words[i], word2 = words[i+1];
            if (word1.length() > word2.length() && word1.startsWith(word2))
                return "";
            for(int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                Character parent = word1.charAt(j), child = word2.charAt(j);
                if(parent != child) {
                    graph.get(parent).add(child);
                    indegree.put(child, indegree.get(child)+1);
                    break;
                }
            }
        }
        
        Queue<Character> queue = new LinkedList<>();
        for(Map.Entry<Character, Integer> entry: indegree.entrySet()) {
            if(entry.getValue() == 0)
                queue.add(entry.getKey());
        }
        
        StringBuilder uniqueString = new StringBuilder();
        while(!queue.isEmpty()) {
            Character ch = queue.poll();
            uniqueString.append(ch);
            List<Character> children = graph.get(ch);
            for(Character child: children) {
                indegree.put(child, indegree.get(child)-1);
                if(indegree.get(child) == 0)
                    queue.add(child);
            }
        }
        
        if(uniqueString.length() != indegree.size())
            return "";
        
        return uniqueString.toString();
    }
}