/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

 

Example 1:

Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]

Example 2:

Input: root = []
Output: []

Example 3:

Input: root = [1]
Output: [1]

Example 4:

Input: root = [1,2]
Output: [1,2]
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-1000 <= Node.val <= 1000

 */

package Hard;
import java.util.*;

public class SerializeAndDeserializeBinaryTree {

    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }

    public String rserialize(TreeNode root, String nodes) {
        if(root == null)
            nodes += "null,";
        else {
            nodes += nodes.valueOf(root.val)+",";
            nodes = rserialize(root.left, nodes);
            nodes = rserialize(root.right, nodes);
        }
        return nodes;
    }
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return rserialize(root, "");   
    }

    public TreeNode rdeserialize(List<String> nodeList) {
        if(nodeList.get(0).equals("null")){
            nodeList.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(nodeList.get(0)));
        nodeList.remove(0);
        root.left = rdeserialize(nodeList);
        root.right = rdeserialize(nodeList);
        return root;
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        List<String> nodesList = new LinkedList<String>(Arrays.asList(nodes));
        return rdeserialize(nodesList);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
