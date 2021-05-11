/**
Check whether the original sequence org can be uniquely reconstructed from the sequences in seqs. The org sequence is a permutation of the integers from 1 to n, with 1 ≤ n ≤ 104. Reconstruction means building a shortest common supersequence of the sequences in seqs (i.e., a shortest sequence so that all sequences in seqs are subsequences of it). Determine whether there is only one sequence that can be reconstructed from seqs and it is the org sequence.

 

Example 1:

Input: org = [1,2,3], seqs = [[1,2],[1,3]]
Output: false
Explanation: [1,2,3] is not the only one sequence that can be reconstructed, because [1,3,2] is also a valid sequence that can be reconstructed.
Example 2:

Input: org = [1,2,3], seqs = [[1,2]]
Output: false
Explanation: The reconstructed sequence can only be [1,2].
Example 3:

Input: org = [1,2,3], seqs = [[1,2],[1,3],[2,3]]
Output: true
Explanation: The sequences [1,2], [1,3], and [2,3] can uniquely reconstruct the original sequence [1,2,3].
Example 4:

Input: org = [4,1,5,2,6,3], seqs = [[5,2,6,3],[4,1,5,2]]
Output: true
 

Constraints:

1 <= n <= 10^4
org is a permutation of {1,2,...,n}.
1 <= segs[i].length <= 10^5
seqs[i][j] fits in a 32-bit signed integer.

 */

package Medium;
import java.util.*;
class SequenceReconstruction {
    public boolean sequenceReconstruction(int[] originalSeq, List<List<Integer>> sequences) {
        List<Integer> sortedOrder = new ArrayList<>();
        if (originalSeq.length <= 0)
          return false;

        // a. Initialize the graph
        HashMap<Integer, Integer> inDegree = new HashMap<>(); // count of incoming edges for every vertex
        HashMap<Integer, List<Integer>> graph = new HashMap<>(); // adjacency list graph
        for (List<Integer> seq : sequences) {
          for (int i = 0; i < seq.size(); i++) {
            inDegree.putIfAbsent(seq.get(i), 0);
            graph.putIfAbsent(seq.get(i), new ArrayList<Integer>());
          }
        }

        // b. Build the graph
        for (List<Integer> seq : sequences) {
          for (int i = 1; i < seq.size(); i++) {
            int parent = seq.get(i - 1), child = seq.get(i);
            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) + 1);
          }
        }

        // if we don't have ordering rules for all the numbers we'll not able to uniquely construct the sequence
        if (inDegree.size() != originalSeq.length)
          return false;

        // c. Find all sources i.e., all vertices with 0 in-degrees
        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
          if (entry.getValue() == 0)
            sources.add(entry.getKey());
        }

        // d. For each source, add it to the sortedOrder and subtract one from all of its children's in-degrees
        // if a child's in-degree becomes zero, add it to the sources queue
        while (!sources.isEmpty()) {
          if (sources.size() > 1)
            return false; // more than one sources mean, there is more than one way to reconstruct the sequence
          if (originalSeq[sortedOrder.size()] != sources.peek())
            return false; // the next source (or number) is different from the original sequence
          int vertex = sources.poll();
          sortedOrder.add(vertex);
          List<Integer> children = graph.get(vertex); // get the node's children to decrement their in-degrees
          for (int child : children) {
            inDegree.put(child, inDegree.get(child) - 1);
            if (inDegree.get(child) == 0)
              sources.add(child);
          }
        }

        // if sortedOrder's size is not equal to original sequence's size, there is no unique way to construct  
        return sortedOrder.size() == originalSeq.length;
    }
}