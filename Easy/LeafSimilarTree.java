/**
 * Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
 For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

Two binary trees are considered leaf-similar if their leaf value sequence is the same.

Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

 

Example 1:

Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
Output: true

Example 2:

Input: root1 = [1], root2 = [1]
Output: true

Example 3:

Input: root1 = [1], root2 = [2]
Output: false

Example 4:

Input: root1 = [1,2], root2 = [2,2]
Output: true

Example 5:

Input: root1 = [1,2,3], root2 = [1,3,2]
Output: false
 

Constraints:

The number of nodes in each tree will be in the range [1, 200].
Both of the given trees will have values in the range [0, 200].
 */

package Easy;
import java.util.*;

public class LeafSimilarTree {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> root1Leaves = new ArrayList<>();
        List<Integer> root2Leaves = new ArrayList<>();
        
        leafFinder(root1, root1Leaves);
        leafFinder(root2, root2Leaves);
        
        if(root1Leaves.size() == root2Leaves.size()) {
            for(int i=0;i<root1Leaves.size();i++) {
                if(root1Leaves.get(i) == root2Leaves.get(i)) {
                    continue;
                }
                else 
                    return false;
            }
        }
        else {
            return false;
        }
        return true;
    }
    
    public static void leafFinder(TreeNode root, List<Integer> rootLeaves) {
        
        if(root == null) return;
        if(root.left == null & root.right == null) {
            rootLeaves.add(root.val);    
        }
        
        leafFinder(root.left, rootLeaves);
        leafFinder(root.right, rootLeaves);
    }

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
}
