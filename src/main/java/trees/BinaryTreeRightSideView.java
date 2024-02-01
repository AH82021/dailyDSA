package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
Given the root of a binary tree, imagine yourself standing on the right side of it,
 return the values of the nodes you can see ordered from top to bottom.
 https://leetcode.com/problems/binary-tree-right-side-view/description/
 */
public class BinaryTreeRightSideView {
    class TreeNode{
        int val;
TreeNode left;
       TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }



        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    /*
    This method initializes the main function that takes the root of the binary tree as input.
     It initializes an ArrayList to store the right side view values. If the root is null, it returns an empty list.
     Otherwise, it calls the bfs method to perform breadth-first search traversal and collect the right side view values.


     */
    public List<Integer> rightSideView(TreeNode root){
        List<Integer> list = new ArrayList<Integer>();
        if(root == null) return list;
        bfs(list, root);
        return list;

    }

    /*
     breadth-first search (BFS) traversal technique to traverse the binary tree and collect the rightmost node values at each level.

     This private method bfs performs the breadth-first search traversal.
     It uses a queue (q) to keep track of the nodes to visit. It starts by offering the root node to the queue.

Then, it enters a while loop that continues until the queue becomes empty.
In each iteration of the loop, it processes all the nodes at the current level:

It retrieves the number of nodes at the current level (levelSize) by getting the size of the queue.
It iterates through each node in the current level by running a for loop from 0 to levelSize.
It dequeues the first node from the queue and adds its value to the list if it's the first node at that level (i == 0).
It enqueues the right child (if it exists) and then the left child (if it exists) of the current node for the next level's traversal.
The time complexity of this algorithm is O(N), where N is the number of nodes in the binary tree. This is because we visit each node once.

The space complexity is O(W), where W is the maximum width of the tree (i.e., the maximum number of nodes at any level in the tree)
 since in the worst case, the queue can contain all the nodes at the maximum width of the tree.


     */




    private void bfs(List<Integer> list, TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = q.poll();
                if(i ==0) list.add(curr.val);
                if(curr.right !=null) q.offer(curr.right);
                if(curr.left != null) q.offer((curr.left));
            }
        }
    }

}
