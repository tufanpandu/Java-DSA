public class rodCutting {
    // ====================Rod Cutting (Variation of 0/1 Knapsack)
    // ====================
    public static int rodCutting(int length[], int price[], int rodLength) {
        int n = length.length;
        // Create dp
        int dp[][] = new int[n + 1][rodLength + 1];
        // Intialize
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < rodLength + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        // Main Code
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < rodLength + 1; j++) {
                if (length[i - 1] <= j) { // Valid
                    // Include
                    int include = price[i - 1] + dp[i][j - length[i - 1]];
                    // Exclude
                    int exclude = dp[i - 1][j];
                    // update the maximun on dp[i][j]
                    dp[i][j] = Math.max(include, exclude);
                } else { // Not Valid
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Print the table
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[n][rodLength];
    }

    public static void main(String[] args) {
        int length[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int price[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int rodLength = 8;
        System.out.println(rodCutting(length, price, rodLength));
    }
}
