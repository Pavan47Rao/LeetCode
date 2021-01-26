/**
 * Given the root node of a binary search tree, return the sum of values of all nodes with a value in the range [low, high].

 

Example 1:
Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
Output: 32

Example 2:
Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
Output: 23
 

Constraints:

The number of nodes in the tree is in the range [1, 2 * 104].
1 <= Node.val <= 105
1 <= low <= high <= 105
All Node.val are unique.

 */

package Easy;

public class RangeSumOfBST {
    int sum;
    public int rangeSumBST(TreeNode root, int L, int R) {
        sum=0;
        dfs(root,L,R);
        return sum;
    }
    public void dfs(TreeNode node, int L, int R) {
        if(node != null) {
            if(L <= node.val && node.val <= R) {
                sum+=node.val;
            }
            if(L < node.val) {
                dfs(node.left, L, R);
            }
            if(node.val < R) {
                dfs(node.right, L, R);
            }
        }
    }
    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }
}
