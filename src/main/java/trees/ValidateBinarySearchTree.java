package trees;
//Given the root of a binary tree, determine if it is a valid binary search tree (BST).
//
//A valid BST is defined as follows:

//The left
//subtree
//of a node contains only nodes with keys less than the node's key.
//The right subtree of a node contains only nodes with keys greater than the node's key.
//Both the left and right subtrees must also be binary search trees.

public class ValidateBinarySearchTree {
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

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return dfs(root, null, null);
    }
    private boolean dfs(TreeNode root,Integer min, Integer max) {
        if(root == null) return true;
        if(min !=null && root.val <= min || max !=null && root.val >= max) return  false;
        return dfs(root.left,min,root.val) && dfs(root.right,root.val,max);
    }

}
