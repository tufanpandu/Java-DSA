// ================ Longest Increasing Subsequence =========================

import java.util.*;

public class LongestIncreasingSubsequence {

    // Create LCS function
    public static int lcs(int arr1[], int arr2[]) {
        int n = arr1.length;
        int m = arr2.length;
        // Create dp
        int dp[][] = new int[n + 1][m + 1];

        // Initialize // In Java it's not need to initialize because it's by Default set
        // '0'.
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        // Buttom up
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                // Same case
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else { // Different Case
                    // If different case is happen then decrease by one of one array and then second
                    // array get maximum and update
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }

    public static int longestIncreasingSubsequence(int arr1[]) {
        // create Hashset for store unique number
        HashSet<Integer> set = new HashSet<>();
        // Add number to Set
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }

        int arr2[] = new int[set.size()]; // Copy array which size is iqual to Set size
        // Iterate over HashSet Using forEach loop
        int i = 0;
        for (int num : set) {
            arr2[i] = num;
            i++;
        }

        // Sort the arr2 in assending order
        Arrays.sort(arr2);

        // Call LCS funciton for arr1 and arr2
        return lcs(arr1, arr2);
    }

    public static void main(String[] args) {
        int arr1[] = { 50, 3, 10, 7, 40, 80 };
        System.out.println(longestIncreasingSubsequence(arr1));
    }
}