import java.util.*;

public class introOfDP {
    // Fibonacci using DP
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

    public static void main(String[] args) {
        int n = 10;
        // Create array for storing return value for n
        int dp[] = new int[n + 1]; // Because array start from 0 index we add +1 into n.
        System.out.println(fib(n, dp));

    }
}
