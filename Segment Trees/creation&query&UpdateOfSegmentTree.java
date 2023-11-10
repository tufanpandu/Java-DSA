
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

    //// ===================== Query on Segment Trees ===========================
    // Util Function
    public static int getSumUtil(int i, int si, int sj, int qi, int qj) {
        // Not overlaping
        if (qj <= si || qi >= sj) {
            return 0;
        } else if (si >= qi && sj <= qj) { // Complete Overlaping

            return tree[i];
        } else { // Partialy overlaping
            int mid = (si + sj) / 2;
            int left = getSumUtil(2 * i + 1, si, mid, qi, qj);
            int right = getSumUtil(2 * i + 2, mid + 1, sj, qi, qj);

            return left + right;
        }
    }

    public static int getSum(int arr[], int qi, int qj) {
        // length of array
        int n = arr.length;
        return getSumUtil(0, 0, n - 1, qi, qj);
    }

    // ===================== Updates on Segment Trees =====================
    // Update Segment Tree
    public static void updateUtil(int i, int si, int sj, int idx, int difference) {
        // Case -1 : Don't lie in the range
        if (idx > sj || idx < si) {
            return; // If the index is outside the range, no need to update.
        }
        // Case -2: Index lies in the range, so we update the segment tree.
        tree[i] += difference; // Update the value in the segment tree.

        // If si == sj, it's a leaf node. Otherwise, it's a non-leaf node.
        if (si != sj) {
            // Find the middle index of the current range.
            int mid = (si + sj) / 2;

            // Update the left child segment tree.
            updateUtil(2 * i + 1, si, mid, idx, difference);

            // Update the right child segment tree.
            updateUtil(2 * i + 2, mid + 1, sj, idx, difference);
        }
    }

    // First, update the array.
    public static void update(int arr[], int idx, int newValue) {
        int n = arr.length;
        int difference = newValue - arr[idx]; // Calculate the difference between the new and old values at arr[idx].
        arr[idx] = newValue; // Update the value in the array.

        // Call the function to update the segment tree.
        updateUtil(0, 0, n - 1, idx, difference);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int n = arr.length;

        // Initialize the Segment Tree
        initialize(n);

        // Build the Segment Tree
        buildST(arr, 0, 0, n - 1);

        // Print the Segment Tree
        // for (int i = 0; i < tree.length; i++) {
        // System.out.print(tree[i] + " ");
        // }

        System.out.println();

        System.out.println(getSum(arr, 2, 5));
        update(arr, 2, 2);
        System.out.println(getSum(arr, 2, 5));

    }
}
