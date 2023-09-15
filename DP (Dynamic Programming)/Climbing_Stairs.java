import java.util.Arrays;

public class Climbing_Stairs {
    // ============Find using Recursion==================
    public static int waysOne(int n) {
        // Base Case
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }

        // Recursion
        return waysOne(n - 1) + (waysOne(n - 2));
    }

    /// ====== Memoization =========
    public static int waysTwo(int n, int ways[]) {
        // base case
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }

        if (ways[n] != -1) { // alredy calulated
            return ways[n];
        }

        ways[n] = waysTwo(n - 1, ways) + waysTwo(n - 2, ways);
        return ways[n];
    }

    // ================== Tabulation ======================
    public static int waysThree(int n) {
        // Create an array for store nth value
        int dp[] = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1] + 0; // update the i th index value.
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 100;

        int ways[] = new int[n + 1]; // 0,0,0,0,0
        Arrays.fill(ways, -1);// -1,-1,-1,-1,-1

        // System.out.println("No of ways is " + waysOne(n));
        // System.out.println("No of ways is " + waysTwo(n, ways));
        System.out.println("No of ways is " + waysThree(n));

    }
}
