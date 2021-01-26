/**
 * Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

As a reminder, a binary search tree is a tree that satisfies these constraints:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Note: This question is the same as 538: https://leetcode.com/problems/convert-bst-to-greater-tree/

 

Example 1:
Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
Example 2:

Input: root = [0,null,1]
Output: [1,null,1]
Example 3:

Input: root = [1,0,2]
Output: [3,3,2]
Example 4:

Input: root = [3,2,4,1]
Output: [7,9,4,10]
 

Constraints:

The number of nodes in the tree is in the range [1, 100].
0 <= Node.val <= 100
All the values in the tree are unique.
root is guaranteed to be a valid binary search tree.
 */

package Medium;

public class BSTToGreaterSumTree {
    int sum=0;
    public TreeNode bstToGst(TreeNode root) {
        if(root==null)
            return null;
        computeSum(root);
        inorderTraversal(root);
        return root;
    }
    public void computeSum(TreeNode node) {
        if(node == null)
            return;
        sum+=node.val;
        computeSum(node.left);
        computeSum(node.right);
    }
    public void inorderTraversal(TreeNode node) {
        if(node.left!=null)
            inorderTraversal(node.left);
        int temp = node.val;
        node.val=sum;
        sum-=temp;
        if(node.right!=null)
            inorderTraversal(node.right);
    }

    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }
}
