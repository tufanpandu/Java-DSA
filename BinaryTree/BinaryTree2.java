import java.util.*;

public class BinaryTree2 {
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

    static class Info {
        int diam;
        int ht;

        public Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;

        }
    }
    //////////////  Count height of   a tree //////////////////////////
    public static int height(Node root) {
        if (root == null) { // Base 
            return 0;
        }
  //Recursively calculate
        int lh = height(root.left);
        int rh = height(root.right);
        int maxHeight = Math.max(lh, rh) + 1;
        return maxHeight;
    }


////////////////// Count of Nodes of a tree //////////////////
public static int count(Node root) {
    if (root == null) {
        return 0;
    }
//Recursively calculate
    int leftCount = count(root.left);
    int rightCount = count(root.right);
    int sum = leftCount + rightCount + 1;
    return sum;
}

    
///////////// Sum of Nodes ////////////
public static int sum(Node root) {
    if (root == null) {
        return 0;
    }
    //Recursively calculate
    int leftSum = sum(root.left);
    int rightSum = sum(root.right);
    return leftSum + rightSum + root.data;
}

//// // Diameter of a Tree  Approch 2
public static Info diameter(Node root) {
    if (root == null) {
        return new Info(0, 0);

    }

    Info leftInfo = diameter(root.left);
    Info rightInfo = diameter(root.right);
    int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
    int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;
    return new Info(diam, ht);
}
    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        // System.out.println(height(root));
        // System.out.println(count(root));
        // System.out.println(sum(root));
        System.out.println(diameter(root).diam);
    }
}
