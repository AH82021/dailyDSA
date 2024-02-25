package trees;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindMinValueOnEachLevel {





        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }
        }

        public List<Integer> findMinForEachLevel(TreeNode root) {
            List<Integer> mins = new ArrayList<>();
            if (root == null) {
                return mins;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                int levelMin = Integer.MAX_VALUE;
                for (int i = 0; i < levelSize; i++) {
                    TreeNode currentNode = queue.poll();
                    levelMin = Math.min(levelMin, currentNode.val);
                    if (currentNode.left != null) {
                        queue.offer(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        queue.offer(currentNode.right);
                    }
                }
                mins.add(levelMin);
            }

            return mins;
        }


}
