/**
 * Design a data structure to store the strings' count with the ability to return the strings with minimum and maximum counts.

Implement the AllOne class:

AllOne() Initializes the object of the data structure.
inc(String key) Increments the count of the string key by 1. If key does not exist in the data structure, insert it with count 1.
dec(String key) Decrements the count of the string key by 1. If the count of key is 0 after the decrement, remove it from the data structure. It is guaranteed that key exists in the data structure before the decrement.
getMaxKey() Returns one of the keys with the maximal count. If no element exists, return an empty string "".
getMinKey() Returns one of the keys with the minimum count. If no element exists, return an empty string "".
 

Example 1:

Input
["AllOne", "inc", "inc", "getMaxKey", "getMinKey", "inc", "getMaxKey", "getMinKey"]
[[], ["hello"], ["hello"], [], [], ["leet"], [], []]
Output
[null, null, null, "hello", "hello", null, "hello", "leet"]

Explanation
AllOne allOne = new AllOne();
allOne.inc("hello");
allOne.inc("hello");
allOne.getMaxKey(); // return "hello"
allOne.getMinKey(); // return "hello"
allOne.inc("leet");
allOne.getMaxKey(); // return "hello"
allOne.getMinKey(); // return "leet"
 

Constraints:

1 <= key.length <= 10
key consists of lowercase English letters.
It is guaranteed that for each call to dec, key is existing in the data structure.
At most 5 * 104 calls will be made to inc, dec, getMaxKey, and getMinKey.
 */

package Hard;
import java.util.*;

public class AllOoneDataStructure {
    Map<String, Integer> stringToCount;
    TreeMap<Integer, HashSet<String>> countToStrings;
    /** Initialize your data structure here. */
    public AllOoneDataStructure() {
        stringToCount = new HashMap<>();
        countToStrings = new TreeMap<>();
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        stringToCount.put(key, stringToCount.getOrDefault(key, 0)+1);
        int freq = stringToCount.get(key);
        removeFromCountToStrings(freq-1, key);
        addToCountToStrings(freq, key);
    }
    
    public void removeFromCountToStrings(int freq, String key) {
        if(countToStrings.containsKey(freq)) {
            HashSet<String> stringSet = countToStrings.get(freq);
            if(stringSet.contains(key))
                stringSet.remove(key);
            if(stringSet.size() == 0)
                countToStrings.remove(freq);
        }
    }
    
    public void addToCountToStrings(int freq, String key) {
        HashSet<String> set = countToStrings.getOrDefault(freq, new HashSet<>());
        set.add(key);
        countToStrings.put(freq, set);
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        int freq = stringToCount.get(key);
        if(freq - 1 == 0)
            stringToCount.remove(key);
        else
            stringToCount.put(key, freq - 1);
        removeFromCountToStrings(freq, key);
        if(freq-1 > 0)
            addToCountToStrings(freq-1, key);
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if(countToStrings.isEmpty())
            return "";
        return countToStrings.get(countToStrings.lastKey()).iterator().next();
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if(countToStrings.isEmpty())
            return "";
        return countToStrings.get(countToStrings.firstKey()).iterator().next();
    }
}
