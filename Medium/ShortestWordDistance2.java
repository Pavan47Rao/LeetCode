/**
 * Design a data structure that will be initialized with a string array, and then it should answer queries of the shortest distance between two different strings from the array.

Implement the WordDistance class:

WordDistance(String[] wordsDict) initializes the object with the strings array wordsDict.
int shortest(String word1, String word2) returns the shortest distance between word1 and word2 in the array wordsDict.
 

Example 1:

Input
["WordDistance", "shortest", "shortest"]
[[["practice", "makes", "perfect", "coding", "makes"]], ["coding", "practice"], ["makes", "coding"]]
Output
[null, 3, 1]

Explanation
WordDistance wordDistance = new WordDistance(["practice", "makes", "perfect", "coding", "makes"]);
wordDistance.shortest("coding", "practice"); // return 3
wordDistance.shortest("makes", "coding");    // return 1
 

Constraints:

1 <= wordsDict.length <= 3 * 104
1 <= wordsDict[i].length <= 10
wordsDict[i] consists of lowercase English letters.
word1 and word2 are in wordsDict.
word1 != word2
At most 5000 calls will be made to shortest.
 */

package Medium;
import java.util.*;

public class ShortestWordDistance2 {
    Map<String, List<Integer>> dict;
    public ShortestWordDistance2(String[] wordsDict) {
        dict = new HashMap<>();
        for(int i = 0; i < wordsDict.length; i++) {
            List<Integer> indices = dict.getOrDefault(wordsDict[i], new ArrayList<Integer>());
            indices.add(i);
            dict.put(wordsDict[i], indices);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> indices1, indices2;
        indices1 = dict.get(word1);
        indices2 = dict.get(word2);
        int i1 = 0, i2 = 0, minDiff = Integer.MAX_VALUE;
        while(i1 < indices1.size() && i2 < indices2.size()) {
            minDiff = Math.min(minDiff, Math.abs(indices1.get(i1) - indices2.get(i2)));
            if(indices1.get(i1) < indices2.get(i2))
                i1++;
            else
                i2++;
        }
        return minDiff;
    }
}
