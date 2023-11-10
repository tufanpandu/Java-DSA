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

    public static void main(String[] args) {
        int arr[] = { 6, 8, -1, 2, 17, 1, 3, 2, 4 };
        int n = arr.length;

        init(n);
        buildST(0, 0, n - 1, arr);

        for (int i = 0; i < n; i++) {
            System.out.print(tree[i] + " ");
        }
    }
}
