
public class Knapsack_Recursion {
    // ============ 0-1 Knapsack Using Recursion ===========================
    public static int zeroOneKnapsack(int val[], int wt[], int W, int n) {
        // Base Case
        if (W == 0 || n == 0) {
            return 0;
        }
        // If item wt is less than knapsack Weight
        if (wt[n - 1] <= W) { // Valid Ans and We have two chooice
            // Include
            int ans1 = val[n - 1] + zeroOneKnapsack(val, wt, W - wt[n - 1], n - 1); // n-1 is update condition
            // Exclude
            int ans2 = zeroOneKnapsack(val, wt, W, n - 1);

            // find Max Value
            return Math.max(ans1, ans2);
        } else {
            // Exclude
            return zeroOneKnapsack(val, wt, W, n - 1);
        }
    }

    public static void main(String[] args) {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int W = 7;

        System.out.println(zeroOneKnapsack(val, wt, W, val.length));
    }
}
