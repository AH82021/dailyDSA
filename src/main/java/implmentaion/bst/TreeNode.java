package implmentaion.bst;

import java.util.Collection;
import java.util.TreeSet;

public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public static void main(String[] args) {
        // [10]
        // [5]   [15]

        //// [0]   [8]  x  [12] [20]
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(20);
        System.out.println(search(0, root));




    }

    public static boolean search( int val ,TreeNode root) {
        TreeNode current =root;
        while (current != null){
            if(val <current.val){
                current = current.left;
            }else if(val > current.val){
                current = current.right;
            } else return true;
        }
        return false;
    }
}
