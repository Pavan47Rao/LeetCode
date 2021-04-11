/**
 * You are given a list of airline tickets where tickets[i] = [fromi, toi] represent the departure and the arrival airports of one flight. Reconstruct the itinerary in order and return it.

All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK". If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.

For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once.

 

Example 1:
Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
Output: ["JFK","MUC","LHR","SFO","SJC"]
Example 2:
Input: tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"] but it is larger in lexical order.
 

Constraints:

1 <= tickets.length <= 300
tickets[i].length == 2
fromi.length == 3
toi.length == 3
fromi and toi consist of uppercase English letters.
fromi != toi

*/

package Medium;
import java.util.*;

public class ReconstructItinerary {
    Map<String, List<String>> flightMap = new HashMap<>();
    Map<String, boolean[]> bitMap = new HashMap<>();
    int flights = 0;
    List<String> result = null;
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> ticket: tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            if(this.flightMap.containsKey(from)) {
                this.flightMap.get(from).add(to);
            }
            else {
                List<String> destList = new LinkedList<>();
                destList.add(to);
                this.flightMap.put(from, destList);
            }
        }
        for(Map.Entry<String, List<String>> entry: this.flightMap.entrySet()) {
            Collections.sort(entry.getValue());
            this.bitMap.put(entry.getKey(), new boolean[entry.getValue().size()]);
        }
        LinkedList<String> route = new LinkedList<>();
        route.add("JFK");
        this.flights = tickets.size();
        this.backtrack(route, "JFK");
        return this.result;
    }
    
    public boolean backtrack(LinkedList<String> route, String src) {
        if(route.size() == this.flights+1) {
            this.result = (List<String>) route.clone();
            return true;
        }
        if(!this.flightMap.containsKey(src)) {
            return false;
        }
        boolean visited[] = this.bitMap.get(src);
        int i = 0;
        for(String dest: this.flightMap.get(src)) {
            if(!visited[i]) {
                route.add(dest);
                visited[i] = true;
                boolean ret = backtrack(route, dest);
                route.pollLast();
                visited[i] = false;
                if(ret)
                    return true;
            }
            ++i;
        }
        return false;
    }
}
