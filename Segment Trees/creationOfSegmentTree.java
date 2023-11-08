
//============== Creation of Segment Trees TC O(n) ==============
import java.util.*;

public class creationOfSegmentTree {
    // Create Segment Tree array
    static int tree[];

    // Initialize the Segment Trees
    public static void initialize(int n) {
        tree = new int[4 * n];
    }

    // Build Segment Tree
    public static int buildST(int arr[], int i, int start, int end) {
        // Base Case
        // If the start and end values are equal (Leaf node), then update the tree and
        // return the start value.
        if (start == end) {
            tree[i] = arr[start];
            return arr[start];
        }

        // Find the first mid
        int mid = (start + end) / 2;

        // Build the left child
        buildST(arr, 2 * i + 1, start, mid);

        // Build the right child
        buildST(arr, 2 * i + 2, mid + 1, end);

        // Update the root node with the sum of the left child and right child node
        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
        return tree[i];
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int n = arr.length;

        // Initialize the Segment Tree
        initialize(n);

        // Build the Segment Tree
        buildST(arr, 0, 0, n - 1);

        // Print the Segment Tree
        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
    }
}
