// ======= Counting Trees BSTs ( Variation of Catalans Number) =============
public class countingBST {
    // Function to count the number of Binary Search Trees (BSTs) with 'n' nodes
    public static int countBST(int n) {
        // Create an array 'dp' to store the number of BSTs for different 'n'
        int dp[] = new int[n + 1];

        // Base Cases: There is one BST for 0 or 1 node
        dp[0] = 1;
        dp[1] = 1;

        // Fill the 'dp' array to calculate the number of BSTs for 'n' nodes
        for (int i = 2; i < n + 1; i++) { // Iterate from 2 to n
            for (int j = 0; j < i; j++) { // Iterate from 0 to i
                int left = dp[j]; // Number of BSTs on the left side
                int right = dp[i - j - 1]; // Number of BSTs on the right side
                dp[i] += left * right; // Multiply left and right BST counts and add to the total
            }
        }

        return dp[n]; // Return the number of BSTs for 'n' nodes
    }

    public static void main(String args[]) {
        int n = 5; // Change 'n' to the desired number of nodes
        System.out.println(countBST(n)); // Print the number of BSTs for 'n' nodes
    }
}
