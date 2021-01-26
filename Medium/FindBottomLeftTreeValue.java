/**
 * Given the root of a binary tree, return the leftmost value in the last row of the tree.

 

Example 1:
Input: root = [2,1,3]
Output: 1

Example 2:
Input: root = [1,2,3,4,null,5,6,null,null,7]
Output: 7
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1

 */

package Medium;

public class FindBottomLeftTreeValue {

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

    public int findBottomLeftValue(TreeNode root) {
        int maxDepth = 1, currentValue = root.val;
        int[] result = {maxDepth, currentValue};
        int currentDepth = 1;
        dfs(currentDepth, result, root);
        return result[1];
    }
    
    public void dfs(int currentDepth, int[] result, TreeNode root) {
        if(root == null)
            return;
        if(root.left == null && root.right == null) {
            if(currentDepth > result[0]) {
                result[0] = currentDepth;
                result[1] = root.val;
            }
        }
        dfs(currentDepth+1, result, root.left);
        dfs(currentDepth+1, result, root.right);
    } 
}
