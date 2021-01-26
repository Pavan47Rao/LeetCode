/**
 * Given a binary search tree, return a balanced binary search tree with the same node values.

A binary search tree is balanced if and only if the depth of the two subtrees of every node never differ by more than 1.

If there is more than one answer, return any of them.

 

Example 1:
Input: root = [1,null,2,null,3,null,4,null,null]
Output: [2,1,3,null,null,null,4]
Explanation: This is not the only correct answer, [3,1,4,null,2,null,null] is also correct.
 

Constraints:

The number of nodes in the tree is between 1 and 10^4.
The tree nodes will have distinct values between 1 and 10^5.
 */

package Medium;
import java.util.*;

public class BalanceABST {
    List<Integer> nodeList = new ArrayList<>();
    
    public void prepareList(TreeNode root) {
        if(root == null)
            return;
        prepareList(root.left);
        nodeList.add(root.val);
        prepareList(root.right);
    }
    
    public TreeNode constructBST(int left, int right) {
        if(left>right)
            return null;
        int mid = left + (right - left)/2;
        TreeNode node = new TreeNode();
        node.val = nodeList.get(mid);
        node.left = constructBST(left, mid-1);
        node.right = constructBST(mid+1, right);
        return node;
    }
    
    public TreeNode balanceBST(TreeNode root) {
        if(root == null)
            return null;
        prepareList(root);
        return constructBST(0, nodeList.size()-1);
    }

    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
         }
}
