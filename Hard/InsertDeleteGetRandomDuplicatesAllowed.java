/**
Implement the RandomizedCollection class:

RandomizedCollection() Initializes the RandomizedCollection object.
bool insert(int val) Inserts an item val into the multiset if not present. Returns true if the item was not present, false otherwise.
bool remove(int val) Removes an item val from the multiset if present. Returns true if the item was present, false otherwise. Note that if val has multiple occurrences in the multiset, we only remove one of them.
int getRandom() Returns a random element from the current multiset of elements (it's guaranteed that at least one element exists when this method is called). The probability of each element being returned is linearly related to the number of same values the multiset contains.
 

Example 1:

Input
["RandomizedCollection", "insert", "insert", "insert", "getRandom", "remove", "getRandom"]
[[], [1], [1], [2], [], [1], []]
Output
[null, true, false, true, 2, true, 1]

Explanation
RandomizedCollection randomizedCollection = new RandomizedCollection();
randomizedCollection.insert(1);   // return True. Inserts 1 to the collection. Returns true as the collection did not contain 1.
randomizedCollection.insert(1);   // return False. Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
randomizedCollection.insert(2);   // return True. Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
randomizedCollection.getRandom(); // getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
randomizedCollection.remove(1);   // return True. Removes 1 from the collection, returns true. Collection now contains [1,2].
randomizedCollection.getRandom(); // getRandom should return 1 and 2 both equally likely.
 

Constraints:

-231 <= val <= 231 - 1
At most 105 calls will be made to insert, remove, and getRandom.
There will be at least one element in the data structure when getRandom is called.
 

Follow up: Could you implement the functions of the class with each function works in average O(1) time?

 */

package Hard;
import java.util.*;

public class InsertDeleteGetRandomDuplicatesAllowed {
    List<Integer> lst;
    Map<Integer, Set<Integer>> idx;
    Random rand;
    
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        lst = new ArrayList<>();
        idx = new HashMap<>();
        rand = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if(!idx.containsKey(val))
            idx.put(val, new LinkedHashSet<>());
        idx.get(val).add(lst.size());
        lst.add(val);
        return idx.get(val).size() == 1;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!idx.containsKey(val) || idx.get(val).size() == 0)
            return false;
        
        //get first val from list of indices in set
        int indexToRemove = idx.get(val).iterator().next();
        
        //remove the first val from set
        idx.get(val).remove(indexToRemove);
        
        //get last value from list
        int lastVal = lst.get(lst.size()-1);
        
        //set indexToRemove-th val with last val since it's going to be deleted
        lst.set(indexToRemove, lastVal);
        
        //add the new index of last val to set
        idx.get(lastVal).add(indexToRemove);
        
        //remove the old index of last val
        idx.get(lastVal).remove(lst.size()-1);
        
        //remove the elt from list
        lst.remove(lst.size()-1);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return lst.get(rand.nextInt(lst.size()));
    }
}