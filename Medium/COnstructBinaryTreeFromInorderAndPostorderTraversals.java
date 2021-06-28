/**
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

 

Example 1:


Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: inorder = [-1], postorder = [-1]
Output: [-1]
 

Constraints:

1 <= inorder.length <= 3000
postorder.length == inorder.length
-3000 <= inorder[i], postorder[i] <= 3000
inorder and postorder consist of unique values.
Each value of postorder also appears in inorder.
inorder is guaranteed to be the inorder traversal of the tree.
postorder is guaranteed to be the postorder traversal of the tree.
 */

package Medium;
import java.util.*;

public class COnstructBinaryTreeFromInorderAndPostorderTraversals {
    int[] inorder;
    int[] postorder;
    Map<Integer, Integer> indexMap;
    int postIdx;
    
    public TreeNode helper(int left, int right) {
        if(left > right)
            return null;
        
        int rootVal = postorder[postIdx];
        TreeNode root = new TreeNode(rootVal);
        
        int index = indexMap.get(rootVal);
        postIdx--;
        
        root.right = helper(index+1, right);
        root.left = helper(left, index-1);
        
        return root;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        indexMap = new HashMap<>();
        postIdx = postorder.length-1;
        for(int i = 0; i < inorder.length; i++)
            indexMap.put(inorder[i], i);
        return helper(0, inorder.length-1);
    }
}
