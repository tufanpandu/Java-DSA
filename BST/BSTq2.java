package BST;

public class BSTq2 {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
//////// 👉👉👉Sorted Array to BalancedBST  //
    public static Node balancedBST(int arr[], int st , int end){
        if(st > end){ //If starting value is grater then ending value then this array is first of all not sorted and return null.
          return null;
        }
        int mid = (st + end)/2; // Find the mid of array
        Node root = new Node(arr[mid]); // Now first create a root node which have value arr of mid.
        root.left =balancedBST(arr , st , mid -1); // Again find the middle between start to mid and this middle is going to root.left.
        root.right = balancedBST(arr , mid+1 , end);// Again find the middle between mid to end and this middle is going to root.left
        return root; //return root 
      }
    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
}

    public static void main(String[] args) {
        int arr[] = { 3, 5, 6, 8, 10, 11, 12 };


        Node root = balancedBST(arr, 0, arr.length-1);
        preOrder(root);
    }
}
