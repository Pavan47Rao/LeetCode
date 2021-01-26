/**
 * Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.

If possible, output any possible result.  If not possible, return the empty string.

Example 1:

Input: S = "aab"
Output: "aba"
Example 2:

Input: S = "aaab"
Output: ""
Note:

S will consist of lowercase letters and have length in range [1, 500].
 */

package Medium;
import java.util.*;

public class ReorganizeString {
    public String reorganizeString(String S) {
        Map<Character, Integer> count = new HashMap();
        for(char ch: S.toCharArray()) {
            count.put(ch, count.getOrDefault(ch, 0)+1);
        }
        
        Queue pq = new PriorityQueue<Character>((a,b) -> count.get(b) - count.get(a));
        for(char ch: count.keySet()) {
            pq.add(ch);
        }
        
        StringBuilder result = new StringBuilder();
        while(pq.size() > 1) {
            Character first = (Character)pq.poll();
            Character second = (Character)pq.poll();
            
            result.append(first);
            result.append(second);
            
            count.put(first, count.get(first)-1);
            count.put(second, count.get(second)-1);
            
            if(count.get(first)>0) {
                pq.add(first);
            }
            if(count.get(second)>0) {
                pq.add(second);
            }
        }
        
        if(pq.size() == 1) {
            Character last = (Character)pq.poll();
            
            if(count.get(last) > 1) {
                return "";
            }
            else {
                result.append(last);
            }
        }
        
        return new String(result);
    }
}
