/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
 */

package Medium;
import java.util.*;

public class BinaryTreeRightSideView {

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

    List<Integer> result = new ArrayList<>();
    
    public void getChild(TreeNode root, int level) {
        if(result.size() == level)
            result.add(root.val);
        if(root.right != null)
            getChild(root.right, level+1);
        if(root.left != null)
            getChild(root.left, level+1);
    }
    
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return result;
        getChild(root, 0);
        return result;
    }
}
