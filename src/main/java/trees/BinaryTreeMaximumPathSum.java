package trees;


/*
124. Binary Tree Maximum Path Sum

A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.
 */
public class BinaryTreeMaximumPathSum {

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
  /*
  Time Complexity:
The time complexity of the algorithm is O(N), where N is the number of nodes in the binary tree.
This is because we visit each node exactly once.
Space Complexity:
The space complexity of the algorithm is O(H),
where H is the height of the binary tree. This is because the recursion stack space used is proportional to the height of the tree.
   */
    public int maxPathSum(TreeNode root) {
         int[] res = {Integer.MIN_VALUE };

         maxPathSum(root,res);
         return res[0];



    }
    /*
    This is the helper method maxPathSum(TreeNode root, int[] res) that recursively calculates the maximum path sum starting from the current node.
It takes the current node root and the array res to store the maximum path sum found so far.
It returns the maximum path sum starting from the current node.
The base case checks if the current node is null. If so, it returns 0.
It recursively computes the maximum path sum for the left and right subtrees.
It calculates the maximum sum for the current node considering three cases: the current node itself,
the current node plus the left subtree, and the current node plus the right subtree.
It updates the maximum path sum stored in res[0] if necessary.
It returns the maximum sum that can be achieved starting from the current node, considering either the left or right subtree.
     */
    public int maxPathSum(TreeNode root, int[] res) {
         if(root == null) return 0;
         int left = Math.max(0,maxPathSum(root.left,res));
         int right = Math.max(0,maxPathSum(root.right,res));
         res[0] =Math.max(res[0],root.val+left+right);

         return root.val +Math.max(left,right);
    }
}


