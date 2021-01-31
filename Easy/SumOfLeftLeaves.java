/**
 * Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */

package Easy;

public class SumOfLeftLeaves {

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

    public int findSum(TreeNode subTree, Boolean isRightNode) {
        if(subTree.right == null && subTree.left == null)
            return isRightNode ? 0 : subTree.val;
        int sum = 0;
        if(subTree.left != null)
            sum += findSum(subTree.left, false);
        if(subTree.right != null)
            sum += findSum(subTree.right, true);
        return sum;
            
    }
    
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null)
            return 0;
        return findSum(root, true);
    }
}
