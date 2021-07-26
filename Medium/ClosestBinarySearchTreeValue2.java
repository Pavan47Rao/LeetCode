/**
 * Given the root of a binary search tree, a target value, and an integer k, return the k values in the BST that are closest to the target. You may return the answer in any order.

You are guaranteed to have only one unique set of k values in the BST that are closest to the target.

 

Example 1:


Input: root = [4,2,5,1,3], target = 3.714286, k = 2
Output: [4,3]
Example 2:

Input: root = [1], target = 0.000000, k = 1
Output: [1]
 

Constraints:

The number of nodes in the tree is n.
1 <= k <= n <= 104.
0 <= Node.val <= 109
-109 <= target <= 109
 

Follow up: Assume that the BST is balanced. Could you solve it in less than O(n) runtime (where n = total nodes)?
 */

package Medium;
import java.util.*;

public class ClosestBinarySearchTreeValue2 {

    public void inorder(Queue<Integer> pq, TreeNode node, int k) {
        if(node == null)
            return;
        inorder(pq, node.left, k);
        pq.add(node.val);
        if(pq.size() > k)
            pq.poll();
        inorder(pq, node.right, k);
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Queue<Integer> pq = new PriorityQueue<>((i1, i2) -> (Math.abs(i1 - target) > Math.abs(i2 - target) ? -1 : 1));
        inorder(pq, root, k);
        return new ArrayList<>(pq);
    }
}
