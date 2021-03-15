/**
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

Example 2:
Input: root = [1]
Output: [[1]]

Example 3:
Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000

 */

package Medium;
import java.util.*;

public class BinaryTreeLevelOrderTraversal {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) {
            queue.add(root);
            queue.add(null);
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        while(queue.size() > 0) {
            TreeNode node = queue.remove();
            if(node != null) {
                level.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            else {
                result.add(level);
                level = new ArrayList<>();
                if(queue.size() == 0)
                    break;
                queue.add(null);
            }
        }
        return result;
    }
}
