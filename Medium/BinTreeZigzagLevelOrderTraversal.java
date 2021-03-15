/**
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]

Example 2:
Input: root = [1]
Output: [[1]]

Example 3:
Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100
 */

package Medium;
import java.util.*;

public class BinTreeZigzagLevelOrderTraversal {

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        queue.add(root);
        queue.add(null);
        List<Integer> level = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Boolean bPrint = true;
        while(queue.size() > 0) {
            TreeNode node = queue.remove();
            if(node != null) {
                if(bPrint)
                    level.add(node.val);
                else 
                    stack.push(node);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            else {
                while(stack.size() > 0)
                    level.add(stack.pop().val);
                result.add(level);
                level = new ArrayList<>();
                if(queue.size() == 0)
                    break;
                queue.add(null);
                bPrint = !bPrint;
                
            }
        }
        return result;
    }
}
