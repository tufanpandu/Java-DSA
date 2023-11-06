import java.util.*;

//======= Minimum Partitiongin (Variation of 0-1 knapsack)
public class minimumPartitioning {
    public static int minimumPartitioning(int num[]) {
        int n = num.length;

        // Calculate the sum of all elements in the 'num' array
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += num[i];
        }

        // Calculate the weight of the knapsack (half of the total sum)
        int w = sum / 2;

        // Create a 2D DP array to store intermediate results
        int dp[][] = new int[n + 1][w + 1];

        // Initialize DP array, although not required in Java
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < w + 1; j++) {
                dp[i][j] = 0;
            }
        }

        // Bottom-Up approach to solve the knapsack problem
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if (num[i - 1] <= j) {
                    // If the current item can fit in the knapsack (valid)
                    // Calculate the maximum value considering whether to include or exclude the
                    // item
                    int include = num[i - 1] + dp[i - 1][j - num[i - 1]];
                    int exclude = dp[i - 1][j];
                    dp[i][j] = Math.max(include, exclude);
                } else {
                    // If the item doesn't fit in the knapsack (not valid), copy the value from the
                    // previous row
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Calculate the difference between the two partitions
        int sum1 = dp[n][w]; // The sum of one partition
        int sum2 = sum - sum1; // The sum of the other partition
        return Math.abs(sum1 - sum2); // Return the absolute difference
    }

    public static void main(String[] args) {
        int num[] = { 1, 6, 11, 5 };
        System.out.println(minimumPartitioning(num));
    }
}
