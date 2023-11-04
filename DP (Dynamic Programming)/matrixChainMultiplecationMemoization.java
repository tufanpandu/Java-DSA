
//============= Matrix Chain Multiplecation using Memoization ================
import java.util.*;

public class matrixChainMultiplecationMemoization {
    public static int mcmMemo(int arr[], int i, int j, int dp[][]) {
        // Base Case: If we are considering only one matrix, there is no multiplication
        // cost.
        if (i == j) {
            return 0;
        }

        // If we have already calculated the result for this subproblem, return it.
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;

        // Try all possible partitions of the matrix chain to find the minimum cost.
        for (int k = i; k <= j - 1; k++) {
            int cost1 = mcmMemo(arr, i, k, dp); // Cost of multiplying matrices from i to k.
            int cost2 = mcmMemo(arr, k + 1, j, dp); // Cost of multiplying matrices from k+1 to j.
            int cost3 = arr[i - 1] * arr[k] * arr[j]; // Cost of multiplying matrices i to k and k+1 to j.
            int finalCost = cost1 + cost2 + cost3; // Total cost for this partition.
            ans = Math.min(ans, finalCost); // Update the minimum cost.
        }

        // Store the minimum cost for this subproblem in the dp table and return it.
        return dp[i][j] = ans;
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 3 };
        int n = arr.length;

        // Create a 2D dp table to memoize subproblem results.
        int dp[][] = new int[n][n];

        // Initialize the dp table with -1 to indicate that results are not calculated
        // yet.
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        // Call the mcmMemo function to find the minimum cost of matrix chain
        // multiplication.
        System.out.println(mcmMemo(arr, 1, n - 1, dp));
    }

}
