public class maxQueries {
    /// Create Segment Tree
    static int tree[];

    // Initialize the segment tree with size 'n'
    public static void init(int n) {
        tree = new int[4 * n]; // The tree size is 4 times 'n'.
    }

    // Build the Segment Tree
    public static void buildST(int i, int si, int sj, int arr[]) {
        // Base Case: If the start and end indices are the same, it's a leaf node.
        if (si == sj) {
            tree[i] = arr[si]; // Set the value of the leaf node to the array element.
            return;
        }

        // Find the middle index of the current range.
        int mid = si + (sj - si) / 2;

        // Build the left child segment tree.
        buildST(2 * i + 1, si, mid, arr);

        // Build the right child segment tree.
        buildST(2 * i + 2, mid + 1, sj, arr);

        // Update the current node value to store the maximum value of its children.
        tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]);
    }

    // =========== Max Element Queries ===============
    // a. Output max for subarray[i,j]
    // This function returns the maximum element in a given range [qi, qj] of the
    // array.
    public static int getMax(int arr[], int qi, int qj) {
        int n = arr.length;
        return getMaxUtil(0, 0, n - 1, qi, qj);
    }

    // This is a utility function for getMax, it recursively finds the maximum in
    // the range [si, sj].
    public static int getMaxUtil(int i, int si, int sj, int qi, int qj) {
        // No overlap
        if (si > qj || sj < qi) {
            return Integer.MIN_VALUE;
        } else if (si <= qi && sj >= qj) { // Complete overlap
            return tree[i]; // Return the value stored in the tree.
        } else { // Partial overlap
            int mid = (si + sj) / 2;
            int leftAns = getMaxUtil(2 * i + 1, si, mid, qi, qj);
            int rightAns = getMaxUtil(2 * i + 2, mid + 1, sj, qi, qj);
            return Math.max(leftAns, rightAns); // Return the maximum of left and right sub-ranges.
        }
    }

    // This function updates an element at the given index (idx) in the array.
    public static void update(int arr[], int idx, int newValue) {
        int n = arr.length;
        tree[idx] = newValue; // Update the element in the tree.
        updateUtil(0, 0, n - 1, idx, newValue);
    }

    // This is a utility function for update, it recursively updates the tree after
    // a value change.
    public static void updateUtil(int i, int si, int sj, int idx, int newValue) {
        if (idx < si || idx > sj) { // No overlapping range, no need to update.
            return;
        }
        if (si == sj) { // Leaf node, update the tree.
            tree[i] = newValue;
        }
        if (si != sj) { // Non-leaf node, update and propagate the change.
            tree[i] = Math.max(tree[i], newValue);
            int mid = (si + sj) / 2;
            updateUtil(2 * i + 1, si, mid, idx, newValue); // Update the left subtree.
            updateUtil(2 * i + 2, mid + 1, sj, idx, newValue); // Update the right subtree.
        }
    }

    public static void main(String[] args) {
        int arr[] = { 6, 8, -1, 2, 17, 1, 3, 2, 4 };
        int n = arr.length;

        init(n);
        buildST(0, 0, n - 1, arr);

        // for (int i = 0; i < n; i++) {
        // System.out.print(tree[i] + " ");
        // }

        System.out.println(getMax(arr, 2, 5));

        update(arr, 2, 20);
        System.out.println(getMax(arr, 2, 5));

    }
}
