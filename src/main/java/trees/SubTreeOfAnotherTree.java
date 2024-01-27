package trees;

public class SubTreeOfAnotherTree {

     // Definition for a binary tree node.
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


        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if(root == null){
                return false;
            }

            if(isSameTree(root,subRoot)){
                return true;
            }

            // Recursively check left and right subtrees of root
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

        }

        private boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true; // Both null, they are the same
            }

            if (p == null || q == null) {
                return false; // One is null, the other isn't
            }

            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

