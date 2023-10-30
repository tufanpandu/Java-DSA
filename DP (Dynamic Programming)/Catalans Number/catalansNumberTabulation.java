// ============ Catalans Number Using Tabulation ===============
public class catalansNumberTabulation {

    // Function to calculate the nth Catalan number using tabulation
    public static int catalanTabu(int n) {
        int dp[] = new int[n + 1];

        // Base Case: Catalan numbers for n = 0 and n = 1 are both 1
        dp[0] = 1;
        dp[1] = 1;

        // Fill in the Catalan numbers for higher values of n
        for (int i = 2; i <= n; i++) { // Iterate from 2 to n
            for (int j = 0; j < i; j++) { // Iterate from 0 to i
                // The Catalan number at index i is calculated by summing up
                // the product of Catalan numbers at indices j and (i - j - 1)
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n]; // Return the Catalan number for the given 'n'
    }

    public static void main(String args[]) {
        int n = 4; // Change 'n' to the desired value for testing
        System.out.println(catalanTabu(n)); // Print the Catalan number for 'n'
    }
}
