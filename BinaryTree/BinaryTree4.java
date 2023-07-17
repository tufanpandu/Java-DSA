import java.util.*;

public class BinaryTree4 {
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
    /////// Lowest Common Ancestore (LCA) Approch 1.
    public static boolean getPath(Node root, int n , ArrayList<Node> path) {
        if (root == null) {
            return false;
        }
        path.add(root); // First add the root at startin point of path
        if (root.data == n) { // if root of data is equal to n value then we get the Node in starting point..
            return true;
        }
     //Now check the root left and right and find the n and store node on path
        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);


        if (foundLeft || foundRight) { // if left or right any side of root we get the node of n value then return true.
            return true;
        }
       path.remove(path.size()-1);
       return false;
    }

    public static Node lca(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();// Create path1 to store path.
        ArrayList<Node> path2 = new ArrayList<>();// Create path2 to store path
        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {// Run loop entire path size.
            if (path1.get(i) != path2.get(i)) {// check if path1 and path2 is not equal then return.
                break;
            }
        }

        // find the lca -> i -1
        Node lca = path1.get(i - 1);// you can write pathq or path2.
        return lca;
    }
    
    ///✅ LCA -> Approch 2 //////////

    public static Node lca2(Node root, int n1, int n2) {
        // check three conditon first 1 - null , 2 - n1 & 3 - n2 is equal to with root or not.
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }
        /// Check Left & Right Lca recursively .
        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        //Left Lca  -> null then return Right Lca.
        if (leftLca == null) {
            return rightLca;
        }
        // Right lca -> null then return Left Lca.
        if (rightLca == null) {
            return leftLca;
        }
        return root;//if Both Left and Right Lca is not null then return root

    }
    

    ///✅ Min Distance Between node ////
    public static int lcaDist(Node root, int n) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }
        int distLeft = lcaDist(root.left, n);
        int distRight = lcaDist(root.right, n);
        if (distLeft == -1 && distRight == -1) {
            return -1;
        }else if(distLeft == -1){
            return distRight +1;
        } else {
            return distLeft + 1;
        }
    }

    public static int minDist(Node root, int n1, int n2) {
        Node lca = lca2(root, n1, n2);
        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);
        return dist1 + dist2;
    }
    
    /// ✅✅ Kth ancester of node   ////
    public static int KthAncester(Node root, int n, int k) {
        if (root == null) { // Base case  if Root is equal to null then return -1;
            return -1;
        }
        if (root.data == n) { //if root of data is equal to value of n then return "0"
            return 0;
        }
        int leftDist = KthAncester(root.left, n, k);//find node in root left .
        int rightDist = KthAncester(root.right, n, k);// fing node in root Right.

        if (leftDist == -1 && rightDist == -1) { // if root left and right is equal to -1 the return -1.
            return -1;
        }
        int max = Math.max(leftDist, rightDist); // Find the maximum between root left and right .
        if (max + 1 == k) { //Maximum value +1 is equal to k value then print root.data
            System.out.println(root.data);
        }

        return max + 1;// 
    }

    // ✅✅Transform to sum Tree approch 1 
    public static int transform1(Node root) {
        if (root == null) { // if root is null then return zero
            return 0;
        }
        int oldData = root.data;// if root is not null then store root of data on my oldData variable.

        int leftChild = transform1(root.left); // Call recursively and get left child or node.
        int rightChild = transform1(root.right);// call recursively and get right child or node.

        root.data = leftChild + rightChild;// Now update the data of root and store the value of leftchild and right child sum.
        return oldData + root.data; //Now return current node data and oldData sum.

    }
    // // ✅✅Transform to sum Tree approch 2
    public static int transform2(Node root) {
        if (root == null) {
            return 0;
        }
        int leftChild = transform2(root.left);
        int rightChild = transform2(root.right);
        int data = root.data;
        root.data = leftChild + rightChild;
        int sum = root.data + data;
        return sum;
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    

    public static void main(String args[]) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        int n1 = 4;
        int n2 = 5;
        
        //System.out.print(lca2(root, n1, n2).data);
       // System.out.print(minDist(root, n1, n2));
        int n = 4;
        int k = 2;
        // KthAncester(root, n, k);
       transform2(root);
       preorder(root);

    }
}
