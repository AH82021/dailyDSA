package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
// 102. Binary Tree Level Order Traversal
//Medium
//Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
// Input: root = [3,9,20,null,null,15,7]
//Output: [[3],[9,20],[15,7]]
public class BinaryTreeLevelOrderTraversal {
     class TreeNode {
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
         List<List<Integer>> result = new ArrayList<List<Integer>>();
      Queue<TreeNode> queue = new LinkedList<>();
      if (root ==null) return result;
      queue.add(root);
      while(!queue.isEmpty()){
          int len = queue.size();
          List<Integer> level = new ArrayList<>();
          for (int i = 0; i < len; i++) {
              TreeNode curr = queue.poll();
              level.add(curr.val);
              if(curr.left !=null){
                  queue.add(curr.left);
              }
              if(curr.right != null){
                  queue.add(curr.right);
              }
          }
          result.add(level);
      }
      return result;
  }
}
