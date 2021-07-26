/**
Given the root of a binary search tree and a target value, return the value in the BST that is closest to the target.

 

Example 1:


Input: root = [4,2,5,1,3], target = 3.714286
Output: 4
Example 2:

Input: root = [1], target = 4.428571
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
0 <= Node.val <= 109
-109 <= target <= 109
 */

package Easy;

public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        Double arr[] = {Double.MAX_VALUE, 0.0};
        return closestValue(root, target, arr);
    }

    public int closestValue(TreeNode node, double target, Double[] arr) {
        if(node == null)
            return;
        Double diff = Math.abs(node.val - target);
        if(diff < arr[0]) {
            arr[0] = diff;
            arr[1] = Double.valueOf(node.val);
        }
        closestValue(node.left, target, arr);
        closestValue(node.right, target, arr);
        return arr[1].intValue();
    }
}

/**
 * Second approach
 * 
 * public int closestValue(TreeNode root, double target) {
 *      int val, closest = root.val;
 *      while(root != null) {
 *          val = root.val;
 *          closest = Math.abs(val - target) > Math.abs(closest - target) ? val : closest;
 *          root = target < root.val ? root.left : root.right;
 *      }
 *      return closest;
 * }
 * 
 */