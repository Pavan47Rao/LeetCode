package Midterm;
import java.util.*;

/**
 * Time complexity: O(n) where n is the size of the tree
 * Space complexity: O(n+m) where n is the number of left nodes and r is the number of right nodes - stack size
 */

public class PerimeterofTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { 
            this.val = val; 
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;this.left = left;this.right = right;
        }    
    }

    void printLeaves(TreeNode node)
    {
        if (node == null)
            return;
  
        printLeaves(node.right);
        if (node.left == null && node.right == null)
            System.out.print(node.val + " ");
        printLeaves(node.left);
    }
  
    void pushLeftBoundaryToStack(TreeNode node)
    {
        if (node == null)
            return;
  
        if (node.left != null) {
            pushLeftBoundaryToStack(node.left);
            System.out.print(node.val+" ");
        }
        else if (node.right != null) {
            pushLeftBoundaryToStack(node.right);
            System.out.print(node.val+" ");
        }
    }
  
    void pushRightBoundaryToStack(TreeNode node)
    {        
        if (node == null)
            return;
  
        if (node.right != null) {
            System.out.print(node.val+" ");
            pushRightBoundaryToStack(node.right);
        }
        else if (node.left != null) {
            System.out.print(node.val+" ");
            pushRightBoundaryToStack(node.left);
        }        
    }
  
    void printPerimeter(TreeNode root)
    {
        if (root == null)
            return;
  
        System.out.print(root.val + " ");
  
        pushRightBoundaryToStack(root.right);

        printLeaves(root.right);
        printLeaves(root.left);
        
        pushLeftBoundaryToStack(root.left);
    }
  
    TreeNode root;
    Stack<Integer> rstack = new Stack<>();
    Stack<Integer> lstack = new Stack<>();
    public static void main(String args[])
    {
        PerimeterofTree tree = new PerimeterofTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.left.left.left = new TreeNode(8);
        tree.root.left.left.right = new TreeNode(9);
        tree.root.left.right.left = new TreeNode(10);
        tree.root.left.right.right = new TreeNode(11);
        tree.root.right = new TreeNode(3);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);
        tree.root.right.left.right = new TreeNode(13);
        tree.root.right.right.left = new TreeNode(14);
        tree.printPerimeter(tree.root);
    }
}
