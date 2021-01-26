/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
 */

package Medium;
import java.util.*;
public class ConstructBinaryTreeFromInorderAndPreorderTraversals {

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

    Map<Integer, Integer> indexMap = new HashMap<>();
    int[] inorder;
    int[] preorder;
    int preidx = 0;
    
    public TreeNode buildTree(int left, int right) {
        if(left == right)
            return null;
        int rootVal = preorder[preidx];
        TreeNode root = new TreeNode(rootVal);
        int index = indexMap.get(rootVal);
        preidx++;
        root.left = buildTree(left, index);
        root.right = buildTree(index+1, right);
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.inorder = inorder;
        this.preorder = preorder;
        for(int i=0;i<inorder.length;i++)
            indexMap.put(inorder[i], i);
        return buildTree(0, inorder.length);
    }
}
