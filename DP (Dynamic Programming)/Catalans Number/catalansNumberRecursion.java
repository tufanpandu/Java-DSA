// ================== Catalans Number Using Recursion ===================
/*
 C0 = 1
 C1 = 1
 C2 = C0.C1+ C1.C0 = 2
 C3 = C0.C2 + C1.C1 + C2.C0 = 5
 C4 = find tha ans //14
 */
public class catalansNumberRecursion {
    // Find Catalans Number
    public static int catalansRec(int n) {

        // Base Case
        if (n == 0 || n == 1) {
            return 1;
        }
        int ans = 0; // Store answer value
        // Recursion
        for (int i = 0; i <= n - 1; i++) {
            ans += catalansRec(i) * catalansRec(n - i - 1);
        }

        return ans;
    }

    public static void main(String args[]) {
        System.out.println(catalansRec(30));
    }
}
