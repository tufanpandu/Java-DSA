///// ======= Coin Change (Variation of unbounded Knapsack) =====================
public class coinChange {
    public static int coinChangeTab(int coin[], int sum) {
        int n = coin.length;
        // Create dp
        int dp[][] = new int[n + 1][sum + 1];
        // Initialize the j th column and i th row
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1; // fill the j th column
        }

        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0; // fill the i th row
        }

        // logic
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {

                if (coin[i - 1] <= j) { // Valid
                    int include = dp[i][j - coin[i - 1]];
                    int exclude = dp[i - 1][j];
                    // Update the current dp index
                    dp[i][j] = include + exclude;
                } else { // Not valid
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int coin[] = { 2, 5, 3, 6 };
        int sum = 10;

        System.out.println(coinChangeTab(coin, sum));
    }
}
