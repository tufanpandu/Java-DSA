import java.util.*;

public class matrixChainMultiplecationTabulation {
    public static int mcmTabu(int arr[]) {
        int n = arr.length;
        // Create a 2D DP array to store intermediate results
        int dp[][] = new int[n][n];

        // Initialize the diagonal elements with 0 because multiplying a matrix with
        // itself costs 0
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0; // in java Language 0 initialization is not requeried
        }

        // Bottom Up approach to calculate the minimum cost for matrix chain
        // multiplication
        for (int length = 2; length <= n - 1; length++) {
            for (int i = 1; i <= n - length; i++) {
                // Calculate the ending column index for the current subproblem
                int j = i + length - 1;
                dp[i][j] = Integer.MAX_VALUE; // Initialize to a large value

                // Split the matrix into two parts at different positions 'k'
                for (int k = i; k <= j - 1; k++) {
                    // Calculate the cost of multiplying the two submatrices and the cost of the
                    // current split
                    int cost1 = dp[i][k];
                    int cost2 = dp[k + 1][j];
                    int cost3 = arr[i - 1] * arr[k] * arr[j];

                    // Update the minimum cost for the current subproblem
                    dp[i][j] = Math.min(dp[i][j], cost1 + cost2 + cost3);
                }
            }
        }
        // The minimum cost for multiplying the entire matrix chain is stored in
        // dp[1][n-1]
        return dp[1][n - 1];
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 3 };
        System.out.println(mcmTabu(arr));
    }

}
