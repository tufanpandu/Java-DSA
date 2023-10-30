
// ===================== Edit Distance ====================
/*
 * Given two strings word1 and word2, return the minimum number of operations
 * required to convert word1 to word2.
 * 
 * You have the following three operations permited on a word:
 * - Insert a character
 * - Delete a character
 * - Replace a character
 * 
 * word1 = "intention"
 * word2 = "execution"
 * //=== ans = 5 ===//
 * 
 * 
 */
import java.util.*;

public class editDistanse {
    public static int editDistanse(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n + 1][m + 1];
        // Initialization
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                }
            }
        }

        // Bottom Up

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                // Same Case
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // Simplely decrease the length of the both word
                } else { // Different Case we hava theree choice like :- Added , Delete and Replace.
                    int added = dp[i][j - 1] + 1; // added
                    int delete = dp[i - 1][j] + 1; // Delete
                    int replace = dp[i - 1][j - 1] + 1; // Replace
                    dp[i][j] = Math.min(added, Math.min(delete, replace)); // You can't do 3 comparision in math method
                                                                           // at a time.
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String word1 = "bdeg";
        String word2 = "abcdef";

        System.out.println(editDistanse(word1, word2));

    }
}