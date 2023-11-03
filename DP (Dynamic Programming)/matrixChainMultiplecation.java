//========= Matrix Chain Multiplecation using Recursion ==================
public class MatrixChainMultiplecation {
    public static int mcm(int arr[], int i, int j) {
        // Base case: If 'i' and 'j' are the same, there's only one matrix, so no
        // multiplication is needed.
        if (i == j) {
            return 0;
        }

        // Initialize 'ans' to a very large value to store the minimum cost.
        int ans = Integer.MAX_VALUE;

        // Loop through different partition points 'k' between 'i' and 'j-1'.
        for (int k = i; k <= j - 1; k++) {
            // Calculate the cost of multiplying matrix 'i' to 'k' (Ai....Ak).
            // The size of the matrix is arr[i-1] x arr[k].
            int cost1 = mcm(arr, i, k);

            // Calculate the cost of multiplying matrix 'k+1' to 'j' (Ak+1 ... Aj).
            // The size of the matrix is arr[k] x arr[j].
            int cost2 = mcm(arr, k + 1, j);

            // Calculate the cost of multiplying the result matrices ('i' to 'k' and 'k+1'
            // to 'j').
            // The size of the result matrix is arr[i-1] x arr[k] x arr[j].
            int cost3 = arr[i - 1] * arr[k] * arr[j];

            // Calculate the total cost of multiplying matrices from 'i' to 'j' through 'k'.
            int finalCost = cost1 + cost2 + cost3;

            // Update 'ans' with the minimum cost found so far.
            ans = Math.min(ans, finalCost);
        }

        // Return the minimum cost of multiplying matrices from 'i' to 'j'.
        return ans;
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 3 };
        int n = arr.length;

        // Call the 'mcm' function with matrix array 'arr', starting from the first
        // matrix (1) and ending at the last matrix (n-1).
        System.out.println(mcm(arr, 1, n - 1));
    }

}