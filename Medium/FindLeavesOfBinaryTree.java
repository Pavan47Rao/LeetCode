/**
 * Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

Example:

Input: [1,2,3,4,5]
  
          1
         / \
        2   3
       / \     
      4   5    

Output: [[4,5,3],[2],[1]]
 

Explanation:

1. Removing the leaves [4,5,3] would result in this tree:

          1
         / 
        2          
 

2. Now removing the leaf [2] would result in this tree:

          1          
 

3. Now removing the leaf [1] would result in the empty tree:

          []         
[[3,5,4],[2],[1]], [[3,4,5],[2],[1]], etc, are also consider correct answers since per each level it doesn't matter the order on which elements are returned.
 */

package Medium;
import java.lang.Math.*;
import java.util.*;

public class FindLeavesOfBinaryTree {
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

    private List<List<Integer>> result;

    public int findHeight(TreeNode root) {
        if(root == null)
            return -1;
        int hLeft = findHeight(root.left);
        int hRight = findHeight(root.right);
        int curHeight = Math.max(hLeft, hRight)+1;
        if(this.result.size() == curHeight)
            this.result.add(new ArrayList<>());
        this.result.get(curHeight).add(root.val);
        return curHeight;
    }

    public List<List<Integer>> findLeaves(TreeNode root) { 
        this.result = new ArrayList<>();
        findHeight(root);
        return this.result;
    }
}
