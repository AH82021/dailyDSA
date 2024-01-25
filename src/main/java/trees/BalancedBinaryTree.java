package trees;

public class BalancedBinaryTree {
    //Given a binary tree, determine if it is height-balanced
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
    // Solution using the bottom-up approach
// TC and SC is On

    public int height(TreeNode root){
        if(root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }
    public boolean isBalanced(TreeNode root) {
  if(root == null) return true;
  int leftHeight = height(root.left);
  int rightHeight = height(root.right);
  return Math.abs(leftHeight -rightHeight) <=1 && isBalanced(root.left) && isBalanced(root.right);
    }
}
