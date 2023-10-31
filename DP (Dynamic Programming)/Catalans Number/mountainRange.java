//========= Mountaing Range ==========
/*
Mountain & Valleys at any moment the number of down strokes can't be more than number of up strokes
Mountain(Up stroks) 
Vslleys (Down Stroks)

 */
public class mountainRange {
    public static int mountainRange(int n) {
        int dp[] = new int[n + 1];
        // Base Case
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            // for i th pair mountain range
            for (int j = 0; j < i; j++) {
                int inside = dp[j];
                int outside = dp[i - j - 1];
                dp[i] += inside * outside;
            }
        }

        return dp[n];
    }

    public static void main(String args[]) {
        int n = 4; // nth pair
        System.out.println(mountainRange(n));
    }
}
