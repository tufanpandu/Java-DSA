package BST;


import java.lang.foreign.VaList;
import java.util.*;

public class BSTbasic1 {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root, int val) {
        if (root == null) {// if root is null then  create a new Node and assing the valu on root.
            root = new Node(val);
            return root;
        }
        //Left subtree
        if (root.data > val) {
            root.left = insert(root.left, val);
        } else {
            //Right subtree
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static void inorder(Node root) { // create an inorder function for create BST.
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    //// Search  is a BST
    public static boolean search(Node root, int key) {
        if (root == null) { // if my key is not found and at last root is equal to null then return false.
            return false;
        }
        //if key is equal to root.data
        if (root.data == key) {
            return true;
        }
        // if root.data is grater then key then search left subtree.
        if (root.data > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    //// 👉👉Delete a Node in BST ///
    //1st - search key node
    //2nd - check the 3 case
    //3rd - delete the node
    public static Node delete(Node root, int key) {
        // left subtree
        if (root.data > key) {
            root.left = delete(root.left, key);// update the left pointer.
        } else if (root.data < key) {
            //Right subtree
            root.right = delete(root.right, key);
        } else { //if root.data is equal to key .
            // check the 3 case.
            //No child - check left and right.
            if (root.left == null && root.right == null) {
                return null;
            }
            // One child or single node
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Two children
            Node IS = findInorderSucessor(root.right);//left most node in right subtree.
            root.data = IS.data; //replace the root of data with IS of data.
            root.right = delete(root.right, IS.data);//root ki right se IS.data ki value ko delete karenge and root.right  pointer ko update karenge.
        }

        return root;
    }
    
    //find Inorder Sucessor
    public static Node findInorderSucessor(Node root) {
        // check the right subtree and find left most node
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }


    //1️⃣ Print in Range
    public static void printInRange(Node root, int k1, int k2) {
        if (root == null) { // if root is null then simple return .
            return;
        }
        if (root.data >= k1 && root.data <= k2) {// if root.data is graterthen equal to k1 and root.data is lessthen k2 then print value in inorder format.
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        } else if (root.data < k1) { // if root.data is lesstthen k1 go to right subtree.
            printInRange(root.right, k1, k2);
        } else {// if root.data is grater then equal to k2 then go to the left subtree.
            printInRange(root.left, k1, k2);
        }
    }

  
    // ////////2️⃣ root to leaf path  //👉👉 Code is not working please conside later
    // public static void printPath(ArrayList<Integer> path) {
    //     for (int i = 0; i < path.size(); i++) {
    //         System.out.print(path.get(i) + " ->");
    //     }
    //     System.out.println("Null");
    // }

    // public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
    //     if (root == null) {
    //         return;
    //     }
    //     path.add(root.data);
      
    //     if (root.left == null && root.right == null) {
    //         printPath(path);
    //     }
    //    printRoot2Leaf(root.left, path);
    //     printRoot2Leaf(root.right, path);
    //     path.remove(path.size()-1);

    // }




    ///3️⃣ Valid BST
    public static boolean validBST(Node root, Node min, Node max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.data <= min.data) {
            return false;
        }
        else if (max != null && root.data >= max.data) {
            return false;
        }

        return validBST(root.left, min, root)
       && validBST(root.right, root, max);
        
    }

    public static void main(String args[]) {
        int value[] = { 1,1,1};
        Node root = null;

        for (int i = 0; i < value.length; i++) { //Treaverse all root 
            root = insert(root, value[i]);
        }
        inorder(root);
       System.out.println();
        //     if (search(root, 6)) {
        //      System.out.print("Found");
        //  } else {
        //     System.out.println("Not found");
        //    }
        // delete(root,1);
        // System.out.println();
        // inorder(root);
        // System.out.println();
        // printInRange(root, 3, 11);

        // printRoot2Leaf(root, new ArrayList<>());
        if (validBST(root, null, null)) {
            System.out.println("Valid BST");
        } else {
            System.out.println("Not Valid");
        }
    }
}
