//============== Unbounded Knapsack ====================
public class unboundedKnapsack {
    // Unbounded Knapsack
    public static int unboundedKnapsack(int val[], int wt[], int W) {
        int n = val.length;
        // Create an dp table
        int dp[][] = new int[n + 1][W + 1];

        // By default java place "0" .
        // We initilaze for understand the logic
        for (int i = 0; i < dp.length; i++) { // fill the jth column with zero
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        // Main Logic
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                // include
                if (wt[i - 1] <= j) {// valid
                    // include
                    int include = val[i - 1] + dp[i][j - wt[i - 1]];
                    // Exclude
                    int exclude = dp[i - 1][j];
                    dp[i][j] = Math.max(include, exclude);
                } else { // Not Valid
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][W];
    }

    public static void main(String[] args) {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int W = 7;

        int result = unboundedKnapsack(val, wt, W);
        System.out.println("Max Profit is " + result);
    }
}
