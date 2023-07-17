import java.io.FileNotFoundException;
import java.lang.module.FindException;

public class RecursionBasic {

    //// Call stack Decreasing Order

    public static void printDec(int n) {
        if (n == 1) {
            System.out.println(1);
            return;
        }
        System.out.println(n + " ");
        printDec(n - 1);
    }

    ///// Call stack Increaseing order
    public static void printInc(int n) {
        if (n == 1) {
            System.out.println(1);
            return;
        }
        printInc(n - 1);
        System.out.println(n);
    }

    ////// Factorial

    public static int fact(int n) {
        if (n == 0) {
            return 1;
        }
        int fnm1 = fact(n - 1);
        int fn = n * fact(n - 1);
        return fn;
    }

    ///// Sum of n Natural number

    public static int sumOfN(int n) {
        if (n == 1) {
            return 1;
        }
        int snm1 = sumOfN(n - 1);
        int sn = n + sumOfN(n - 1);
        return sn;
    }

    ////// Fibonacci Number

    public static int fib(int n) {

        if (n == 0 || n == 1) {
            return n;
        }
        int fnm1 = fib(n - 1);
        int fnm2 = fib(n - 2);
        int fb = fnm1 + fnm2;
        return fb;
    }

    ///// Array is shorted ?

    public static boolean isShorted(int arr[], int i) {
        if (i == arr.length - 1) {
            return true;
        }
        if (arr[i] > arr[i + 1]) {
            return false;
        }

        return isShorted(arr, i + 1);

    }

    ///// First Occurence of an element

    public static int firstOccurence(int arr[], int key, int i) {
        if (i == arr.length - 1) {
            return -1;
        }
        if (arr[i] == key) {
            return i;
        }
        return firstOccurence(arr, key, i + 1);
    }

    ///// Last Occurence
    public static int lastOccurence(int arr[], int key, int i) {

        if (i == arr.length) {
            return -1;
        }
        int isFound = lastOccurence(arr, key, i + 1);
        if (isFound == -1 && arr[i] == key) {
            return i;
        }
        return isFound;
    }

    //// Print x^n

    public static int power(int x, int n) {
        if (n == 1) {
            return x;
        }
        int fnm1 = power(x, n - 1);
        int result = x * fnm1;
        return result;

    }

    //// print x^n in O(logn)
    public static int power2(int a, int n) {
        if (n == 0) {
            return 1;
        }
        int halfpower = power2(a, n / 2);
        int powersq = halfpower * halfpower;
        if (n % 2 != 0) {
            powersq = a * powersq;

        }
        return powersq;
    }

    ///// Tiling Problem

    public static int tilingProblem(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        // vertically
        int fnm1 = tilingProblem(n - 1);

        // Horizontaly
        int fnm2 = tilingProblem(n - 2);

        int totWays = fnm1 + fnm2;
        return totWays;
    }

    //// Remove Duplicate

    public static void removeDuplicate(String str, int idx, StringBuilder newStr, boolean map[]) {
        // Base Case
        if (idx == str.length()) {
            System.out.println(newStr);
            return;
        }
        // Kaam
        char currChar = str.charAt(idx);
        if (map[currChar - 'a'] == true) {
            // duplicate
            removeDuplicate(str, idx + 1, newStr, map);
        } else {
            map[currChar - 'a'] = true;
            removeDuplicate(str, idx + 1, newStr.append(currChar), map);
        }
    }

    ///// Friends Pairing Problem
    public static int friendsPairing(int n) {
        // Base
        if (n == 1 || n == 2) {
            return n;
        }

        // Choise
        // Single Pair
        int fnm1 = friendsPairing(n - 1);

        // Double Pair
        int fnm2 = friendsPairing(n - 2);
        int pairWays = (n - 1) * fnm2;

        int totWays = fnm1 + pairWays;
        return totWays;
    }

    ////// Binary String Problem
    public static void binaryString(int n, int lastplace, String str) {
        //// Base Case
        if (n == 0) {
            System.out.println(str);
            return;
        }

        /// Kaam
        binaryString(n - 1, 0, str + "0");

        if (lastplace == 0) {
            binaryString(n - 1, 1, str + "1");
        }
    }

    public static void main(String[] args) {
        // System.out.println("Decreasing Order");
        // printDec(10);
        // System.out.println(" Increasing Order ");
        // printInc(10);
        // System.out.println("Factorial");
        // System.out.println(fact(4));
        // System.out.println("Sum of N Natural number");
        // System.out.println(sumOfN(10));
        // System.out.println("Fibonacci Number");
        // System.out.println(fib(5));
        // System.out.println("is Number is shorted");
        // int arr[] = { 1, 2, 3, 4, 5, 6 };
        // System.out.println(isShorted(arr, 0));
        // System.out.println("First Occurence");
        // int arr[] = { 8, 3, 6, 9, 5, 10, 2, 5, 3 };
        // // System.out.println(firstOccurence(arr, 5, 0));
        // System.out.println("Last Occurence");
        // System.out.println(lastOccurence(arr, 5, 0));
        // System.out.println(power(2, 10));
        // System.out.println(power2(2, 5));
        // System.out.println(tilingProblem(5));

        // String str = "appnnacollege";
        // removeDuplicate(str, 0, new StringBuilder(""), new boolean[26]);

        // System.out.println(friendsPairing(3));
        binaryString(3, 0, "");

    }
}