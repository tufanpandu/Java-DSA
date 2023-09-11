import java.util.*;

public class introOfDP {
    // Fibonacci using DP //👉Memoiztion (Top Down)
    public static int fib(int n, int dp[]) { // O(n)
        if (n == 0 || n == 1) {
            return n;
        }

        if (dp[n] != 0) {// dp[n] is alredy calulate or not check.
            return dp[n];
        }
        // find fibonacci
        int fibnm1 = fib(n - 1, dp);
        int fibnm2 = fib(n - 2, dp);

        dp[n] = fibnm1 + fibnm2; // store the sum value into the dp array of n index.
        return dp[n];
    }

    // Solve problem using 👉Tabulation(Bottom Up)
    public static int tabulationFib(int n) {
        // initialize
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        // Create array for storing return value for n
        int dp[] = new int[n + 1]; // Because array start from 0 index we add +1 into n.
        // System.out.println(fib(n, dp));
        System.out.println(tabulationFib(n));

    }
}
