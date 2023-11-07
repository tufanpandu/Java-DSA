import java.util.*;

//========== Min Array Jumps ==========================
public class minArrayJumpls {
    public static int minArrayJumps(int num[]) {
        int n = num.length;
        // Create a 1D array "dp" to store the minimum number of jumps required to reach
        // the end.
        int dp[] = new int[n];
        // Fill the "dp" array with -1 to check if a result has already been computed
        // for a position.
        Arrays.fill(dp, -1);
        // Initialize the destination (last element) with 0 jumps because we're already
        // there.
        dp[n - 1] = 0;

        // Bottom-up approach to fill the "dp" array.
        for (int i = n - 2; i >= 0; i--) {
            // Find the maximum number of steps we can take from the current position.
            int step = num[i];
            int ans = Integer.MAX_VALUE;

            // Iterate through possible steps from the current position.
            for (int j = i + 1; j <= i + step && j < n; j++) {
                // Check if a result has already been calculated for the next position.
                if (dp[j] != -1) {
                    // If yes, update the answer with the minimum of the current answer and (next
                    // position's answer + 1).
                    ans = Math.min(ans, dp[j] + 1);
                }
            }

            // If the answer still holds the initial value (Integer.MAX_VALUE), it means no
            // valid jump sequence was found,
            // so we don't update it. Otherwise, store the minimum jumps in the "dp" array.
            if (dp[i] != Integer.MAX_VALUE) {
                dp[i] = ans;
            }
        }

        // Return the minimum jumps required to reach the beginning from the starting
        // position (0).
        return dp[0];
    }

    public static void main(String[] args) {
        int num[] = { 2, 3, 1, 1, 4 };
        System.out.println(minArrayJumps(num));
    }

}
