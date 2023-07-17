package BST;
import java.util.*;


public class BSTq4 {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
   /////////👉👉👉👉 Size of largest BST in BT //
    static class Info {/// for stor differt information of data of Node.
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isBST, int size, int min, int max) { // Check the 4 infomation 
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;

        }

    }
    
    public static int maxBST = 0; //// Calculate the size of largest BST.

    public static Info largestBST(Node root) {

        if (root == null) {  //Base Case.
            return new Info(true,0 ,Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Info leftInfo = largestBST(root.left);// stor infomation of root.left
        Info rightInfo = largestBST(root.right);// store infomation of root.right
        int size = leftInfo.size + rightInfo.size + 1; // Calcualte the size by adding leftInfo and rightInfo of size  plus One(which is own size).
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));// find min value between root , root.left and root.right.
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));// find max value between root, root.left and root.right.

        if (root.data <= leftInfo.max || root.data >= rightInfo.min) { // Invalid BST condition.
            return new Info(false, size, min, max);
        }

        if (leftInfo.isBST && rightInfo.isBST) { // Valid BST condition.
            maxBST = Math.max(maxBST, size); // Calculate the size.
            return new Info(true, size, min, max); // return true if is valid condition is true.
        }

        return new Info(false,size,min,max) ;
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);
        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        Info info = largestBST(root);
        System.out.println( "Size of Largest is " + maxBST);
    }
}
