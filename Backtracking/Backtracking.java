package Backtracking;

public class Backtracking {

    ///////// Bascktracking Array /////////

    public static void changeArr(int arr[], int i, int value) {
        // Base Case
        if (i == arr.length) {
            printArr(arr);
            return;
        }
        /// Recursion ( Kaam)
        arr[i] = value; // Assign index value on vlaue
        changeArr(arr, i + 1, value + 1);
        arr[i] = arr[i] - 2;

    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "");
        }
        System.out.println();
    }

    //////// 2️⃣ Backtracking Subsets ////////////

    public static void subset(String str, String ans, int i) {
        // Base Case
        if (i == str.length()) {
            System.out.println(ans);
            return;
        }
        // Recursion (Kaam)

        subset(str, ans + str.charAt(i), i + 1);// Yes Choice
        subset(str, ans, i + 1);// No choice

    }

    //////// 3️⃣ Find Permutation ///////
    public static void findPermutations(String str, String ans) {
        // Base Case
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        // Kaam
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            String due = str.substring(0, i) + str.substring(i + 1);
            findPermutations(due, ans + curr);

        }
    }

    public static void main(String[] args) {
        // int arr[] = new int[5];
        // changeArr(arr, 0, 1);
        // printArr(arr);
        // String str = "abc";
        // subset(str, " ", 0);
        String str = "abc";
        findPermutations(str, "");

    }

}
