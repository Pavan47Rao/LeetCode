/**
 * Given the root of a binary search tree, and an integer k, return the kth (1-indexed) smallest element in the tree.

 

Example 1:


Input: root = [3,1,4,null,2], k = 1
Output: 1
Example 2:


Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
 

Constraints:

The number of nodes in the tree is n.
1 <= k <= n <= 104
0 <= Node.val <= 104
 

Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?

 */

package Medium;
import java.util.*;

public class KthSmallestEltInBST {
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
        return nums.get(k-1);
    }
    
    public ArrayList<Integer> inorder(TreeNode node, ArrayList<Integer> nums) {
        if(node == null)
            return nums;
        inorder(node.left, nums);
        nums.add(node.val);
        inorder(node.right, nums);
        return nums;
    }
}
