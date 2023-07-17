import java.util.*;
import java.util.LinkedList;
public class BinaryTree3 {
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
///// SubTree of another tree ////
    public static boolean isIdentical(Node node, Node subRoot) {
        if (node == null && subRoot == null) {
            return true;
        } else if (node == null || subRoot == null || node.data != subRoot.data) {
            return false;
        }

        if (!isIdentical(node.left, subRoot.left)) {
            return false;
        }
        if (!isIdentical(node.right, subRoot.right)) {
            return false;
        }

        return true;
        
    }

    public static boolean isSubTree(Node root, Node subRoot) {
        if (root == null) {
            return false;
        }
        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }

        return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
    }


    /////// Top view of Binary Tree //////////////////

    static class Info {
        int hd; // Horizontal distance
        Node node;

        public Info(Node node,int hd) { //if you write the constrocto then you have to follow the order of argument
            this.node = node;
            this.hd = hd;
        }
    }
    
    public static void topView(Node root) {
        //Level Order Traverse
        Queue<Info> q = new LinkedList<>(); // create a queue to take Info object
        HashMap<Integer, Node> map = new HashMap<>();// create a hashmap to store the data of node and hd as  Info class.
        int min = 0; // track a minimum hd (Horizontal Distance) of Tree
        int max = 0; // maximum hd 
       q.add(new Info(root, 0)); // First time we add the  Info into the queue . as root and hd as (0) as by default
       q.add(null);  //add null into the queue.
       while (!q.isEmpty()) {

           Info curr = q.remove(); // store current Info into curr

           if (curr == null) {
               if (q.isEmpty()) {
                   break;
               } else {
                   q.add(null);
               }
           } else {
               // Use a function called (map.containsKey(key)) to check the key is inside the map or not.
               if (!map.containsKey(curr.hd)) {// if contains key in map then return true else return false.
                   map.put(curr.hd, curr.node); //if hashmap don't have duplicate value then put hd and node into map.
               }

               if (curr.node.left != null) { // if current node of left child is not null .
                   q.add(new Info(curr.node.left, curr.hd - 1)); // add the curr node of left child and hd into the queue.
                   min = Math.min(min, curr.hd - 1); //find the minmum value.
               }
               if (curr.node.right != null) {//if current node of right child is not null .
                   q.add(new Info(curr.node.right, curr.hd + 1));// add the curr node of right child and hd into the queue.
                   max = Math.max(max, curr.hd + 1); // find the maximum value.
               }

               
            }
        }
        for (int i = min; i <= max; i++) { // print the map data from minimum hd to maximum hd(Horizontal Distance).
            System.out.print(map.get(i).data);
        }
        System.out.println();
    }

    
    public static void main(String args[]) {

        ///// Main Root //////////
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        
        

        ///// Sub Tree ////
         
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        //System.out.println(isSubTree(root, subRoot));
        topView(root); // call the topview tree.
    }
}
