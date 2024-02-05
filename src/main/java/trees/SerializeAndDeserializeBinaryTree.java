package trees;

import java.util.ArrayList;
import java.util.List;
// Serialize and Deserialize Binary Tree

/**
 Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer,
 or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

 Design an algorithm to serialize and deserialize a binary tree.
 There is no restriction on how your serialization/deserialization algorithm should work.
 You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

 Clarification: The input/output format is the same as how LeetCode serializes a binary tree.
 You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 */

public class SerializeAndDeserializeBinaryTree {
    private int i;
    // Definition for a binary tree node.


     class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
     }

     public String serialize(TreeNode root) {
         List<String> children = new ArrayList<String>();
         serializeDFS(root, children);
         return String.join(",", children);
     }

     private void serializeDFS(TreeNode root, List<String> list) {
         if(root == null){
             list.add("N");
             return;
         }
         list.add(String.valueOf(root.val));
         serializeDFS(root.left, list);
         serializeDFS(root.right, list);
     }
    // Decodes your encoded data to tree.
     public TreeNode deserialize(String data){
         String[] tokens = data.split(",");
         return deserializeDFS(tokens);
     }

    private TreeNode deserializeDFS(String[] tokens) {
         String token = tokens[this.i];
         if(token.equals("N")){
             this.i++;
             return null;
         }
         var node = new TreeNode(Integer.parseInt(token));
         this.i++;
         node.left = deserializeDFS(tokens);
         node.right = deserializeDFS(tokens);
         return node;
    }
    // Your Codec object will be instantiated and called as such:
// SerializeAndDeserializeBinaryTree ser = new SerializeAndDeserializeBinaryTree();
// SerializeAndDeserializeBinaryTree deser = new SerializeAndDeserializeBinaryTree();
// TreeNode ans = deser.deserialize(ser.serialize(root));

}
