
// ============== Catalans Number using Mamoization ==================
import java.util.*;

public class catalansNumberMemoization {
    public static int catalanMemo(int n, int dp[]) {
        // Base Case
        if (n == 0 || n == 1) {
            return 1;
        }
        // Already Exsist or not
        if (dp[n] != -1) {
            return dp[n];
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += catalanMemo(i, dp) * catalanMemo(n - i - 1, dp);
        }

        return dp[n] = ans;
    }

    public static void main(String args[]) {
        int n = 10;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(catalanMemo(n, dp));
    }
}
