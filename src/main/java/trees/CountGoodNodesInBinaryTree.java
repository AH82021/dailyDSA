package trees;

public class CountGoodNodesInBinaryTree {

    /*
    Time Complexity: O(n) where n is the number of nodes in the binary tree.
    The algorithm traverses each node exactly once.

Space Complexity: O(h)  where h is the height of the binary tree.
//This is the space used by the function call stack during the recursive traversal,
 which can go as deep as the height of the tree.
     */
    public int goodNodes(TreeNode root) {
        return helper(root, -99999);
    }

    public int helper(TreeNode root, int max) {
        if (root == null) return 0;
        // Check if the current node's value is greater than or equal to the maximum value encountered so far
        // If yes, then it's a good node, so increment the result count by 1; otherwise, it's not a good node

        int res = root.val >= max ? 1 : 0;

        // Recursively call the helper method for the left subtree, updating the maximum value encountered so far
        res += helper(root.left, Math.max(root.val, max));

        // Recursively call the helper method for the right subtree, updating the maximum value encountered so far
        res += helper(root.right, Math.max(root.val, max));

        return res;
    }
}
