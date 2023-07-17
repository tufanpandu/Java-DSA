package BST;
import java.util.*;

public class BSTq5 {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    ////// 👉👉👉✅ Merge 2 BSTs
    public static void inOrder(Node root, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }
        inOrder(root.left, arr);
        arr.add(root.data);
        inOrder(root.right, arr);
    }

    public static Node createBST(ArrayList<Integer> finalarr, int st, int end) {
        if (st > end) {
            return null;
        }
        int mid = (st + end) / 2;
        Node root = new Node(finalarr.get(mid));
        root.left = createBST(finalarr, st, mid - 1);
        root.right = createBST(finalarr, mid + 1, end);
        return root;
    }

    public static Node mergeBSTs(Node root1, Node root2) {

        // Create  arr1 to store sorte list
        ArrayList<Integer> arr1 = new ArrayList<>();
        inOrder(root1, arr1);
      /// create arr2 to Store  sorte list
        ArrayList<Integer> arr2 = new ArrayList<>();
        inOrder(root2, arr2);
      /// ✅✅ create finalarrlist to store both arr1 and arr2.
        ArrayList<Integer> finalarr = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < arr1.size() && j < arr2.size()) { // i is lessthen arr1.size() and  j is lessthen arr2.size.
            if (arr1.get(i) >= arr2.get(j)) {
                finalarr.add(arr2.get(j));
                j++;
            } else {
                finalarr.add(arr1.get(i));
                i++;
            }
        }

     /// left arraylist
        while (i < arr1.size()) { 
            finalarr.add(arr1.get(i));
            i++;
        }

        while (j < arr2.size()) {
            finalarr.add(arr2.get(j));
                j++;
        }

        // Merge BST
        return createBST(finalarr, 0, finalarr.size() - 1);
    }
    
    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String[] args) {
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);


        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node root = mergeBSTs(root1, root2);
        preOrder(root);
    }
}
