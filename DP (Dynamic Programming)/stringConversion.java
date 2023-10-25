
//======= String Conversion =========
import java.util.*;

public class StringConversion {
    // LCS -Longest Common Substring
    public static int lcs(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];
        int ans = 0;

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        // Bottom Up
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                // Same Case
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1; // Update dp[i][j] with 1
                    ans = Math.max(ans, dp[i][j]); // find the maximum between prev ans and current dp[i][j] cell value.
                } else { // Different Case
                    dp[i][j] = 0; // if different case is occure the update with 0
                }
            }
        }
        return ans;

    }

    // String conversion funciton
    public static void stringConversion(String str1, String str2) {
        // length of both string
        int str1Length = str1.length();
        int str2Length = str2.length();
        int resultLength = lcs(str1, str2);
        // Delete
        int delete = str1Length - resultLength;
        int insert = str2Length - delete;
        int ans = delete + insert;

        System.out.println("No.of Deleteion is : " + delete + ", No.of Insertion is : " + insert
                + " Total No.of insertion and Deletetion is : " + ans);
    }

    public static void main(String args[]) {
        String str1 = "tufan";
        String str2 = "pandu";
        stringConversion(str1, str2);
    }
}
