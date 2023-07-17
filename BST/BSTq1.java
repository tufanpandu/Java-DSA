package BST;
import java.util.*;
public class BSTq1 {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
    //// 1️⃣👉👉👉👉👉 Mirror a BST ////
    public static Node createMirror(Node root) {
        if (root == null) {
            return null;
        }
        
        Node leftMirror = createMirror(root.left);
        Node rightMirror = createMirror(root.right);
        root.left = rightMirror;
        root.right = leftMirror;
        
        return root;
        
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    ////////2️⃣ root to leaf path  //👉👉 Code is not working please conside later
    public static void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " ->");
        }
        System.out.println("Null");
    }

    public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
      
        if (root.left == null && root.right == null) {
            printPath(path);
        }
       printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);
        path.remove(path.size()-1);

    }
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right = new Node(10);
        root.right.right = new Node(11);



        // root = createMirror(root);
        // preOrder(root);
        printRoot2Leaf(root, new ArrayList<>());
        
      

    }
}
