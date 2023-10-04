public class KnapsackMemoization {
    /**
     * Solve the 0-1 Knapsack problem using Memoization (Top-down approach).
     *
     * @param val An array of values for each item.
     * @param wt  An array of weights for each item.
     * @param W   The maximum weight capacity of the knapsack.
     * @param n   The number of items to consider.
     * @param dp  A memoization table to store computed results.
     * @return The maximum value that can be obtained within the given constraints.
     */
    public static int knapsackMemoization(int val[], int wt[], int W, int n, int dp[][]) {
        // Base Case
        if (W == 0 || n == 0) {
            return 0;
        }

        // Check if the result for this subproblem has already been computed
        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        // Main logic
        if (wt[n - 1] <= W) {// Valid item
            // Include the current item
            int include = val[n - 1] + knapsackMemoization(val, wt, W - wt[n - 1], n - 1, dp);
            // Exclude the current item
            int exclude = knapsackMemoization(val, wt, W, n - 1, dp);

            // Find and memoize the maximum value
            dp[n][W] = Math.max(include, exclude);
            return dp[n][W];
        } else {// Invalid item (too heavy)
            // Skip the current item and memoize the result
            dp[n][W] = knapsackMemoization(val, wt, W, n - 1, dp);
            return dp[n][W];
        }
    }

    public static void main(String[] args) {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int W = 7;
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];

        // Initialize the memoization table with -1 for all cells
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        // Find and print the maximum value using the knapsackMemoization function
        int result = knapsackMemoization(val, wt, W, n, dp);
        System.out.println("Maximum value: " + result);
    }
}
