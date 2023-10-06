public class Knapsack_Tabulation {
    // ============== 0/1 Knapsack Using Tabulation =======================
    public static int knapsackTabu(int val[], int wt[], int W) {
        int n = val.length;
        // Create dp[] 2D Array metrix
        int dp[][] = new int[n + 1][W + 1];
        // Initialize dp[][] table with 0 for row and column
        for (int i = 0; i < dp.length; i++) { // fill jth culomn with 0 .
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) {// fill ith row with 0 .
            dp[0][j] = 0;
        }

        // main logic
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                int value = val[i - 1];// ith item value .
                int weight = wt[i - 1]; // ith item weight.

                // Condition
                if (weight <= j) { // Valid
                    // include
                    int include = value + dp[i - 1][j - weight];
                    // Exclude
                    int exclude = dp[i - 1][j];
                    // Update maximu profit
                    dp[i][j] = Math.max(include, exclude);

                } else { // Not valid
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // // Print Tabulation table
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < W; j++) {
        // System.out.print(dp[i][j] + " ");
        // }
        // System.out.println();
        // }

        return dp[n][W];
    }

    public static void main(String[] args) {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int W = 7;
        System.out.println(knapsackTabu(val, wt, W));
    }
}
