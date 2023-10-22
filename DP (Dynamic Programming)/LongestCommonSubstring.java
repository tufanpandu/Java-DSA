//// ====== Longest Common Substring =====================
public class LongestCommonSubstring {
    public static int longestCommontString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int ans = 0; // for storing maximum length

        // Create dp table
        int dp[][] = new int[n + 1][m + 1];
        // Initialize dp table
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        // main code
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                // Same case
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, dp[i][j]); // Update the ans with max length.
                } else { // Different Case
                    dp[i][j] = 0; // Update (i,j) with 0;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str1 = "ABCDGH";
        String str2 = "ACDGHR";

        System.out.println(longestCommontString(str1, str2));

    }
}
