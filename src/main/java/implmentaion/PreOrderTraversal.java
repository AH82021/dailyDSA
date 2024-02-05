package implmentaion;

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        this.left = this.right = null;
    }
}

public class PreOrderTraversal {
 Node root;
public  void  preorder(Node root){
    if(root == null) return;
    System.out.print(root.value+" -> " );
    preorder(root.left);
    preorder(root.right);
}

public void inOrder(Node root){
    if(root == null) return;
    preorder(root.left);
    System.out.print (root.value+" -> " );

    preorder(root.right);
}

public  void  postOrder(Node root){
    if(root == null) return;
    preorder(root.left);
    preorder(root.right);
    System.out.print (root.value+" -> " );

}

    public static void main(String[] args) {
     PreOrderTraversal tree = new PreOrderTraversal();
     tree.root = new Node(1);
     tree.root.left = new Node(2);
     tree.root.left.left = new Node(4);
     tree.root.left.right = new Node(5);
     tree.root.right =new Node(3);
     tree.root.right.right = new Node(7);
     tree.root.right.left = new Node(6);



//     tree.postOrder(tree.root);
//        System.out.println();
//        System.out.println(findMax(tree.root));

        System.out.println(searchInBinaryTree(tree.root,4));
        addValue(tree.root,9);
        tree.inOrder(tree.root);



    }

    public static boolean searchInBinaryTree(Node root, int val) {
        // Base case: if the root is null, return false (element not found)
        if (root == null) {
            return false;
        }

        // Check if the current node's value matches the target value
        if (root.value == val) {
            return true;
        }

        // Recursively search in the left and right subtrees
        boolean foundInLeftSubtree = searchInBinaryTree(root.left, val);
        boolean foundInRightSubtree = searchInBinaryTree(root.right, val);

        // Return true if the element is found in either subtree
        return foundInLeftSubtree || foundInRightSubtree;
    }


    public static int findMax(Node root){
     if(root == null)  {
         return  Integer.MIN_VALUE;
     }
     //find the maximum element in the left subtree
        int leftMax = findMax(root.left);
     int rightMax = findMax((root.right));
     return Math.max(root.value,Math.max(leftMax,rightMax));

    }

    public static Node addValue(Node root,int value){
     if(root == null) {
        return  new Node(value);
     }

     if(value <root.value){
        root.left = addValue(root.left,value);
     } else if(value > root.value) {
       root.right =  addValue(root.right, value);
     }

     return  root;



    }




}
