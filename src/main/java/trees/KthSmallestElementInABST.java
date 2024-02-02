package trees;

import java.util.ArrayList;
import java.util.List;

/*
Given the root of a binary search tree, and an integer k,
 return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 */



//Time Complexity:
//
//The time complexity of the kthSmallest function is O(n), where n is the number of nodes in the binary search tree. This is because the inorder traversal visits each node in the tree exactly once.
//The time complexity of the inorder function is also O(n), for the same reason.
//Space Complexity:
//
//The space complexity of the kthSmallest function is O(1), as it only uses a constant amount of extra space for the variables count and result.
//The space complexity of the inorder function is O(n), as it uses a recursive call stack to keep track of the nodes that have been visited so far.
//Here is a line-by-line explanation of the code:
//
//kthSmallest(TreeNode root, int k):
//
//List<Integer> values = new ArrayList<>();: This line creates an empty list to store the values of the nodes in the tree.
//inorder(root, values);: This line calls the inorder function to perform an inorder traversal of the tree and add the values of the nodes to the values list.
//return values.get(k - 1);: This line returns the value at index k - 1 of the values list, which is the kth smallest value in the tree.
//inorder(TreeNode root, List<Integer> values):
//
//        if (root == null) return;: This line checks if the current node is null. If it is, the function returns immediately.
//inorder(root.left, values);: This line recursively calls the inorder function on the left child of the current node.
//        values.add(root.val);: This line adds the value of the current node to the values list.
//inorder(root.right, values);: This line recursively calls the inorder function on the right child of the current node.
public class KthSmallestElementInABST {
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

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> values = new ArrayList<>();
        inorder(root, values);
        return values.get(k-1);

    }

    private void inorder(TreeNode root, List<Integer> values) {
        if(root ==null) return;
        inorder(root.left,values);
        values.add(root.val);
        inorder(root.right,values);
    }


}

/*
Inorder traversal is one of the three common ways to visit nodes in a binary tree, visiting the left subtree, root,
 then right subtree. It's particularly useful for sorted binary search trees (BSTs) where it visits nodes in ascending order.

 Here's how you can implement inorder traversal in Java:

 Recursive Approach:

Java
public void inorderTraversal(TreeNode root) {
  if (root == null) {
    return; // Base case: empty tree
  }
  inorderTraversal(root.left); // Visit left subtree recursively
  System.out.print(root.val + " "); // Visit root node
  inorderTraversal(root.right); // Visit right subtree recursively
}


 Explanation:

Base Case: If the current node (root) is null, there are no more nodes to visit, so the function returns.
Left Subtree: Recursively call inorderTraversal on the left child (root.left) to visit all nodes in the left subtree first.
Root Node: After visiting the left subtree, print the value of the current node (root.val).
Right Subtree: Recursively call inorderTraversal on the right child (root.right) to visit all nodes in the right subtree.
 Time Complexity: O(n), visits each node once.
Space Complexity: O(n) due to recursive call stack.

 Iterative Approach:

Java
public void inorderTraversalIterative(TreeNode root) {
  Stack<TreeNode> stack = new Stack<>();
  TreeNode current = root;

  while (current != null || !stack.isEmpty()) {
    while (current != null) {
      stack.push(current);
      current = current.left;
    }
    current = stack.pop();
    System.out.print(current.val + " ");
    current = current.right;
  }
}
Use code with caution. Learn more

 Explanation:

Stack: Use a stack to keep track of nodes to visit.
Iterate: While either the current node (current) is not null or the stack is not empty:
Push Lefts: While current is not null, push it onto the stack and move to its left child (current = current.left).
Pop and Print: Pop the top node from the stack (current = stack.pop()) and print its value.
Move Right: Move to the right child of the popped node (current = current.right).
 Time Complexity: O(n), visits each node once.
Space Complexity: O(n) due to the stack.

 Choosing the Right Approach:

Recursive approach is simpler and easier to understand.
Iterative approach is more memory efficient for large trees.
 Additional Notes:

In a BST, inorder traversal visits nodes in ascending order.
This code can be modified to collect node values in a list instead of printing them directly.
Inorder traversal has various applications, such as printing sorted elements in a BST, finding the kth smallest element,
and morphological operations on binary trees.
*/
