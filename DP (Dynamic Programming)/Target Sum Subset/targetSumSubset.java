//=================== Target Sum Subset Using Tabulation =========
public class targetSumSubset {
    // Target sum subset
    public static boolean targetSumSubsetTab(int arr[], int sum) {
        int n = arr.length;
        // create an dp[][] which type is boolean
        boolean dp[][] = new boolean[n + 1][sum + 1];
        // By default every cell is has false value.
        // So only we have to fill the jth column with true value for initalizing.
        // i - item , j - target sum
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

        // Tabulation code
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                int value = arr[i - 1];
                // condition
                // include
                if (value <= j && dp[i - 1][j - value] == true) {
                    dp[i][j] = true;
                }
                // Exclude
                else if (dp[i - 1][j] == true) {
                    dp[i][j] = true;
                }
            }
        }

        /**
         * // print table
         * for (int i = 0; i < n + 1; i++) {
         * for (int j = 0; j < sum + 1; j++) {
         * System.out.print(dp[i][j] + " ");
         * }
         * System.out.println();
         * }
         * System.out.println();
         */

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int arr[] = { 4, 2, 7, 1, 3 };
        int sum = 10;
        System.out.println(targetSumSubsetTab(arr, sum));
    }
}
