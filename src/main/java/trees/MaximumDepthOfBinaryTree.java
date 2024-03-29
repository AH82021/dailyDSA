package trees;

public class MaximumDepthOfBinaryTree {

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

    public int maxDepth(TreeNode root){
        if(root == null) return 0;
        return 1 +Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
